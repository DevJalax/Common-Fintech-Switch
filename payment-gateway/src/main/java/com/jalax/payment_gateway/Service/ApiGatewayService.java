package com.jalax.payment_gateway.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.ApiGateway;
import com.jalax.payment_gateway.Repo.ApiGatewayRepository;

@Service
public class ApiGatewayService {
	
    private final ApiGatewayRepository repository;

    public ApiGatewayService(ApiGatewayRepository repository) {
        this.repository = repository;
    }

    public List<ApiGateway> getAllServices() {
        return repository.findAll();
    }

    public ApiGateway getServiceByName(String serviceName) throws Exception {
        return repository.findByServiceName(serviceName)
                .orElseThrow(() -> new Exception("Service not found: " + serviceName));
    }

    public ApiGateway createService(ApiGateway service) {
        return repository.save(service);
    }

    public ApiGateway updateService(Long id, ApiGateway updatedService) throws Exception {
        ApiGateway service = repository.findById(id)
                .orElseThrow(() -> new Exception("Service not found: " + id));

        service.setServiceName(updatedService.getServiceName());
        service.setServiceUrl(updatedService.getServiceUrl());
        service.setServiceDescription(updatedService.getServiceDescription());

        return repository.save(service);
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }
}
