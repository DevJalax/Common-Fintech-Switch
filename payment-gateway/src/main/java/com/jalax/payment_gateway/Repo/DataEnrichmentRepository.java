package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.DataEnrichment;
import com.jalax.payment_gateway.Entity.DataSource;

@Repository
public interface DataEnrichmentRepository extends JpaRepository<DataEnrichment, Long> {
	
    List<DataEnrichment> findByDataSource(DataSource dataSource);

}
