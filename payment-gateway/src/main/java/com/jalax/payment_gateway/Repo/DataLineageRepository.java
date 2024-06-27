package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.DataLineage;
import com.jalax.payment_gateway.Entity.DataSource;

@Repository
public interface DataLineageRepository extends JpaRepository<DataLineage, Long> {
	
    List<DataLineage> findBySourceDataSource(DataSource dataSource);
    
    List<DataLineage> findByTargetDataSource(DataSource dataSource);

}
