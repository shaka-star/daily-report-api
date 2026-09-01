package com.example.daily_report_api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 日報ID

    @Column(nullable = false)
    private LocalDate workDate;  // 日付

    @Column(nullable = false)
    private Double workHours;  // 作業時間

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  // 業務内容

    @Column(columnDefinition = "TEXT")
    private String impressions;  // 所感

    //---コンストラクタ---
    public Report() {
    }

    public Report(LocalDate workDate, Double workHours, String content, String impressions) {
        this.workDate = workDate;
        this.workHours = workHours;
        this.content = content;
        this.impressions = impressions;
    }

    // --- Getter / Setter ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public Double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Double workHours) {
        this.workHours = workHours;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }
}

