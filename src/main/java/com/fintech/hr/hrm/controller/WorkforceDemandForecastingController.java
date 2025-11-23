package com.fintech.hr.hrm.controller;

import com.fintech.hr.hrm.model.WorkforceDemandForecasting;
import com.fintech.hr.hrm.service.WorkforceDemandForecastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/forecasting/workforce")
public class WorkforceDemandForecastingController {

    @Autowired
    private WorkforceDemandForecastingService service;

    /**
     * POST /forecasting/workforce/run
     * Trigger an automated demand forecast run
     */
    @PostMapping("/run")
    public WorkforceDemandForecasting runForecast(@RequestBody WorkforceDemandForecasting forecast) {
        return service.runForecast(forecast);
    }

    /**
     * GET /forecasting/workforce/{period}
     * Retrieve forecast results for a specific quarter or year
     */
    @GetMapping("/{period}")
    public List<WorkforceDemandForecasting> getForecastByPeriod(@PathVariable String period) {
        return service.getForecastByPeriod(period);
    }

    /**
     * GET /forecasting/workforce
     * Get all forecasts
     */
    @GetMapping
    public List<WorkforceDemandForecasting> getAllForecasts() {
        return service.getAllForecasts();
    }

    /**
     * GET /forecasting/workforce/id/{id}
     * Get forecast by ID
     */
    @GetMapping("/id/{id}")
    public WorkforceDemandForecasting getForecastById(@PathVariable String id) {
        return service.getForecastById(id);
    }

    /**
     * PATCH /forecasting/workforce/{id}/adjust
     * Manually adjust forecasted headcount (manager override)
     */
    @PatchMapping("/{id}/adjust")
    public WorkforceDemandForecasting adjustForecast(
            @PathVariable String id,
            @RequestBody Map<String, Object> adjustmentData) {

        int newForecastedDemand = (Integer) adjustmentData.get("newForecastedDemand");
        String adjustedBy = (String) adjustmentData.get("adjustedBy");

        return service.adjustForecast(id, newForecastedDemand, adjustedBy);
    }

    /**
     * GET /forecasting/workforce/department/{department}
     * Get forecasts by department
     */
    @GetMapping("/department/{department}")
    public List<WorkforceDemandForecasting> getForecastsByDepartment(@PathVariable String department) {
        return service.getForecastsByDepartment(department);
    }

    /**
     * GET /forecasting/workforce/status/{status}
     * Get forecasts by status
     */
    @GetMapping("/status/{status}")
    public List<WorkforceDemandForecasting> getForecastsByStatus(@PathVariable String status) {
        return service.getForecastsByStatus(status);
    }

    /**
     * DELETE /forecasting/workforce/{id}
     * Delete a forecast
     */
    @DeleteMapping("/{id}")
    public String deleteForecast(@PathVariable String id) {
        service.deleteForecast(id);
        return "Forecast deleted successfully with id: " + id;
    }
}