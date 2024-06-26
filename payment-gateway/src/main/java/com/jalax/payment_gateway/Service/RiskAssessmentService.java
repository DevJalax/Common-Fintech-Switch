package com.jalax.payment_gateway.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.RiskAssessment;
import com.jalax.payment_gateway.Repo.RiskAssessmentRepository;

@Service
public class RiskAssessmentService {
    private final RiskAssessmentRepository riskAssessmentRepository;

    @Autowired
    public RiskAssessmentService(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public List<RiskAssessment> getAllRiskAssessments() {
        return riskAssessmentRepository.findAll();
    }

    public Optional<RiskAssessment> getRiskAssessmentById(Long id) {
        return riskAssessmentRepository.findById(id);
    }

    public RiskAssessment createRiskAssessment(RiskAssessment riskAssessment) {
        return riskAssessmentRepository.save(riskAssessment);
    }

    public RiskAssessment updateRiskAssessment(Long id, RiskAssessment riskAssessment) {
        Optional<RiskAssessment> existingRiskAssessment = riskAssessmentRepository.findById(id);
        if (existingRiskAssessment.isPresent()) {
            RiskAssessment updatedRiskAssessment = existingRiskAssessment.get();
            updatedRiskAssessment.setCustomerName(riskAssessment.getCustomerName());
            updatedRiskAssessment.setCustomerAddress(riskAssessment.getCustomerAddress());
            updatedRiskAssessment.setCreditScore(riskAssessment.getCreditScore());
            updatedRiskAssessment.setRiskScore(riskAssessment.getRiskScore());
            return riskAssessmentRepository.save(updatedRiskAssessment);
        } else {
            throw new RuntimeException("Risk assessment not found with id: " + id);
        }
    }

    public void deleteRiskAssessment(Long id) {
        riskAssessmentRepository.deleteById(id);
    }
}
