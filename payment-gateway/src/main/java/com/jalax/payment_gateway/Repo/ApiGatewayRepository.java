package com.jalax.payment_gateway.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.ApiGateway;

@Repository
public interface ApiGatewayRepository extends JpaRepository<ApiGateway, Long> {
	
    Optional<ApiGateway> findByServiceName(String serviceName);

}
