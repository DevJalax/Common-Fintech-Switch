package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.DataSource;
import com.jalax.payment_gateway.Service.DataManagementService;

@RestController
@RequestMapping("/api/data-sources")
public class DataSourceController {
	
    private final DataManagementService dataManagementService;

    @Autowired
    public DataSourceController(DataManagementService dataManagementService) {
        this.dataManagementService = dataManagementService;
    }

    @GetMapping
    public List<DataSource> getAllDataSources() {
        return dataManagementService.getAllDataSources();
    }

    @GetMapping("/{id}")
    public DataSource getDataSourceById(@PathVariable Long id) {
        return dataManagementService.getDataSourceById(id);
    }

    @PostMapping
    public DataSource createDataSource(@RequestBody DataSource dataSource) {
        return dataManagementService.createDataSource(dataSource);
    }

    // Update and delete methods
}
