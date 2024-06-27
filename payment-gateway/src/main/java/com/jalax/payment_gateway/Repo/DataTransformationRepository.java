package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.DataSource;
import com.jalax.payment_gateway.Entity.DataTransformation;

@Repository
public interface DataTransformationRepository extends JpaRepository<DataTransformation, Long> {
	
    List<DataTransformation> findByDataSource(DataSource dataSource);

}
