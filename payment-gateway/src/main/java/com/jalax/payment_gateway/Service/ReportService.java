package com.jalax.payment_gateway.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Report;
import com.jalax.payment_gateway.Repo.ReportRepository;

@Service
public class ReportService {
	
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) throws Exception {
        return reportRepository.findById(id)
                .orElseThrow(() -> new Exception("Report not found with id: " + id));
    }

    public Report createReport(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report updatedReport) throws Exception {
        Report report = getReportById(id);
        report.setName(updatedReport.getName());
        report.setDescription(updatedReport.getDescription());
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) throws Exception {
        Report report = getReportById(id);
        reportRepository.delete(report);
    }

    public List<Report> searchReportsByName(String name) {
        return reportRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Report> getReportsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return reportRepository.findByCreatedAtBetween(startDate, endDate);
    }
}
