package com.jalax.payment_gateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalax.payment_gateway.Entity.DataModel;
import com.jalax.payment_gateway.Entity.DataSource;

@Repository
public interface DataModelRepository extends JpaRepository<DataModel, Long> {
	
    List<DataModel> findByDataSource(DataSource dataSource);

}
