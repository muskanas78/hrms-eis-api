package com.fintech.hr.hrm.service;

import com.fintech.hr.hrm.model.WorkforceDemandForecasting;
import com.fintech.hr.hrm.repository.WorkforceDemandForecastingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WorkforceDemandForecastingService {

    @Autowired
    private WorkforceDemandForecastingRepository repository;

    /**
     * Trigger a new forecast run (POST /forecasting/workforce/run)
     */
    public WorkforceDemandForecasting runForecast(WorkforceDemandForecasting forecast) {
        // Generate unique forecast ID
        String forecastId = "FORECAST-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        forecast.setForecastId(forecastId);

        // Calculate forecasted demand with null checks
        Integer currentHead = (forecast.getCurrentHeadcount() != null) ? forecast.getCurrentHeadcount() : 0;
        Double attrition = (forecast.getAttritionRate() != null) ? forecast.getAttritionRate() : 0.0;

        Integer attritionLoss = (int) (currentHead * attrition / 100);
        Integer projectRequirement = (forecast.getProjectPipeline() != null) ? forecast.getProjectPipeline().size() * 5 : 0;
        Integer calculatedDemand = currentHead - attritionLoss + projectRequirement;

        forecast.setForecastedDemand(calculatedDemand);
        forecast.setProjectedHeadcount(currentHead + calculatedDemand);
        forecast.setStatus("COMPLETED");
        forecast.setForecastDate(LocalDateTime.now());
        forecast.setCreatedAt(LocalDateTime.now());
        forecast.setUpdatedAt(LocalDateTime.now());

        // Save to MongoDB
        return repository.save(forecast);
    }

    /**
     * Get forecast results by period (GET /forecasting/workforce/{period})
     */
    public List<WorkforceDemandForecasting> getForecastByPeriod(String period) {
        List<WorkforceDemandForecasting> forecasts = repository.findByPeriod(period);
        if (forecasts.isEmpty()) {
            throw new RuntimeException("No forecast found for period: " + period);
        }
        return forecasts;
    }

    /**
     * Get all forecasts
     */
    public List<WorkforceDemandForecasting> getAllForecasts() {
        return repository.findAll();
    }

    /**
     * Get forecast by ID
     */
    public WorkforceDemandForecasting getForecastById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found with id: " + id));
    }

    /**
     * Manually adjust forecasted headcount (PATCH /forecasting/workforce/{id}/adjust)
     */
    public WorkforceDemandForecasting adjustForecast(String id, Integer newForecastedDemand, String adjustedBy) {
        WorkforceDemandForecasting forecast = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found with id: " + id));

        Integer currentHead = (forecast.getCurrentHeadcount() != null) ? forecast.getCurrentHeadcount() : 0;

        // Update the forecast
        forecast.setForecastedDemand(newForecastedDemand);
        forecast.setProjectedHeadcount(currentHead + newForecastedDemand);
        forecast.setStatus("ADJUSTED");
        forecast.setTriggeredBy(adjustedBy);
        forecast.setUpdatedAt(LocalDateTime.now());

        // Save to MongoDB
        return repository.save(forecast);
    }

    /**
     * Get forecasts by department
     */
    public List<WorkforceDemandForecasting> getForecastsByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    /**
     * Get forecasts by status
     */
    public List<WorkforceDemandForecasting> getForecastsByStatus(String status) {
        return repository.findByStatus(status);
    }

    /**
     * Delete forecast by ID
     */
    public void deleteForecast(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Forecast not found with id: " + id);
        }
        repository.deleteById(id);
    }
}