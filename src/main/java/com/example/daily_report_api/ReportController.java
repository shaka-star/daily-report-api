package com.example.daily_report_api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {
    private final ReportRepository reportRepository;

    // ReportRepository　を　DI(依存性注入)
    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // 日報一覧取得AP（GET/api/v1/reports)
    @GetMapping
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // 日報新規登録API（POST/api/v1/reports）
    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportRepository.save(report);
    }
    // 指定IDの日報詳細取得API（GET/api/v1/reports/{id})
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"指定されたIDの日報が見つかりません。" + id));
    }

    // 指定IDの日報更新API（PUT/api/v1\reports/{id})
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id,@RequestBody Report updatedReport) {
        return reportRepository.findById(id)
                .map(existingReport -> {
                    existingReport.setWorkDate(updatedReport.getWorkDate());
                    existingReport.setWorkHours(updatedReport.getWorkHours());
                    existingReport.setContent(updatedReport.getContent());
                    existingReport.setImpressions(updatedReport.getImpressions());
                    return reportRepository.save(existingReport);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"指定されたIDの日報が見つかりません。" + id));
    }
    // 指定IDの日報削除API（DELETE/api/v1/reports/{id})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable Long id) {
        if(!reportRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"指定されたIDの日報が見つかりません。" + id);
        }
        reportRepository.deleteById(id);
    }
}