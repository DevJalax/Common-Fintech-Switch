package com.jalax.payment_gateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.Configuration;
import com.jalax.payment_gateway.Service.ConfigurationService;

@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {
	
    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping("/{key}")
    public ResponseEntity<Configuration> getConfiguration(@PathVariable String key) throws Exception {
        Configuration configuration = configurationService.getConfiguration(key);
        return ResponseEntity.ok(configuration);
    }

    @PostMapping
    public ResponseEntity<Configuration> createConfiguration(@RequestBody Configuration configuration) {
        Configuration createdConfiguration = configurationService.createConfiguration(configuration);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConfiguration);
    }

    @PutMapping("/{key}")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable String key, @RequestBody Configuration configuration) throws Exception {
        Configuration updatedConfiguration = configurationService.updateConfiguration(key, configuration);
        return ResponseEntity.ok(updatedConfiguration);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable String key) throws Exception {
        configurationService.deleteConfiguration(key);
        return ResponseEntity.noContent().build();
    }
}
