package com.jalax.payment_gateway.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalax.payment_gateway.Entity.RiskAssessment;
import com.jalax.payment_gateway.Service.RiskAssessmentService;

@RestController
@RequestMapping("/api/risk-assessments")
public class RiskAssessmentController {
    private final RiskAssessmentService riskAssessmentService;

    @Autowired
    public RiskAssessmentController(RiskAssessmentService riskAssessmentService) {
        this.riskAssessmentService = riskAssessmentService;
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessment>> getAllRiskAssessments() {
        List<RiskAssessment> riskAssessments = riskAssessmentService.getAllRiskAssessments();
        return ResponseEntity.ok(riskAssessments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessment> getRiskAssessmentById(@PathVariable Long id) {
        Optional<RiskAssessment> riskAssessment = riskAssessmentService.getRiskAssessmentById(id);
        return riskAssessment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RiskAssessment> createRiskAssessment(@RequestBody RiskAssessment riskAssessment) {
        RiskAssessment createdRiskAssessment = riskAssessmentService.createRiskAssessment(riskAssessment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRiskAssessment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessment> updateRiskAssessment(@PathVariable Long id, @RequestBody RiskAssessment riskAssessment) {
        RiskAssessment updatedRiskAssessment = riskAssessmentService.updateRiskAssessment(id, riskAssessment);
        return ResponseEntity.ok(updatedRiskAssessment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRiskAssessment(@PathVariable Long id) {
        riskAssessmentService.deleteRiskAssessment(id);
        return ResponseEntity.noContent().build();
    }
}
