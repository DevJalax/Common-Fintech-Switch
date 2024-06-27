package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.DataTransformation;
import com.jalax.payment_gateway.Service.DataManagementService;

@RestController
@RequestMapping("/api/data-transformations")
public class DataTransformationController {
	
    private final DataManagementService dataManagementService;

    @Autowired
    public DataTransformationController(DataManagementService dataManagementService) {
        this.dataManagementService = dataManagementService;
    }

    @GetMapping
    public List<DataTransformation> getAllDataTransformations() {
        return dataManagementService.getAllDataTransformations();
    }

    @GetMapping("/{id}")
    public DataTransformation getDataTransformationById(@PathVariable Long id) {
        return dataManagementService.getDataTransformationById(id);
    }

    @PostMapping
    public DataTransformation createDataTransformation(@RequestBody DataTransformation dataTransformation) {
        return dataManagementService.createDataTransformation(dataTransformation);
    }

    // Update and delete methods
}
