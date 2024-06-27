package com.jalax.payment_gateway.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Repo.DataEnrichmentRepository;
import com.jalax.payment_gateway.Repo.DataLineageRepository;
import com.jalax.payment_gateway.Repo.DataModelRepository;
import com.jalax.payment_gateway.Repo.DataQualityRuleRepository;
import com.jalax.payment_gateway.Repo.DataSourceRepository;
import com.jalax.payment_gateway.Repo.DataTransformationRepository;

@Service
public class DataManagementService {
	
    private final DataSourceRepository dataSourceRepository;
    
    private final DataTransformationRepository dataTransformationRepository;
    
    private final DataModelRepository dataModelRepository;
    
    private final DataEnrichmentRepository dataEnrichmentRepository;
    
    private final DataQualityRuleRepository dataQualityRuleRepository;
    
    private final DataLineageRepository dataLineageRepository;

    @Autowired
    public DataManagementService(DataSourceRepository dataSourceRepository,
                                 DataTransformationRepository dataTransformationRepository,
                                 DataModelRepository dataModelRepository,
                                 DataEnrichmentRepository dataEnrichmentRepository,
                                 DataQualityRuleRepository dataQualityRuleRepository,
                                 DataLineageRepository dataLineageRepository) {
        this.dataSourceRepository = dataSourceRepository;
        this.dataTransformationRepository = dataTransformationRepository;
        this.dataModelRepository = dataModelRepository;
        this.dataEnrichmentRepository = dataEnrichmentRepository;
        this.dataQualityRuleRepository = dataQualityRuleRepository;
        this.dataLineageRepository = dataLineageRepository;
    }

    // CRUD methods for each entity
}
