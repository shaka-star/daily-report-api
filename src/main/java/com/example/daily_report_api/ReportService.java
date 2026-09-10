package com.example.daily_report_api;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {

    // Repository をインジェクション（注入）
    private final ReportRepository reportRepository;

    // コンストラクタ注入
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // --- 一覧取得 (GET) ---
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // --- 新規登録 (POST) ---
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    // --- 更新処理 (PUT) ---
    public Report updateReport(Long id, Report updatedReport) {
        return reportRepository.findById(id)
                .map(report -> {
                    report.setWorkDate(updatedReport.getWorkDate());
                    report.setWorkHours(updatedReport.getWorkHours());
                    report.setContent(updatedReport.getContent());
                    report.setImpressions(updatedReport.getImpressions());
                    return reportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Report not found with id: " + id));
    }

    // --- 削除処理 (DELETE) ---
    public void deleteReport(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new RuntimeException("Report not found with id: " + id);
        }
        reportRepository.deleteById(id);
    }
}