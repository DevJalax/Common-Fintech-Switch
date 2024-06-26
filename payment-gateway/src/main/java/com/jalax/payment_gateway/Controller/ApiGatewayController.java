package com.jalax.payment_gateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.ApiGateway;
import com.jalax.payment_gateway.Service.ApiGatewayService;

@RestController
@RequestMapping("/api/gateway-services")
public class ApiGatewayController {
	
    private final ApiGatewayService service;

    @Autowired
    public ApiGatewayController(ApiGatewayService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApiGateway> getAllServices() {
        return service.getAllServices();
    }

    @GetMapping("/{serviceName}")
    public ApiGateway getServiceByName(@PathVariable String serviceName) throws Exception {
        return service.getServiceByName(serviceName);
    }

    @PostMapping
    public ApiGateway createService(@RequestBody ApiGateway service) {
        return this.service.createService(service);
    }

    @PutMapping("/{id}")
    public ApiGateway updateService(@PathVariable Long id, @RequestBody ApiGateway service) throws Exception {
        return this.service.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
