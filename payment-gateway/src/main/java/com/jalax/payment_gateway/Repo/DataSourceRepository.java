package com.jalax.payment_gateway.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
	
}
