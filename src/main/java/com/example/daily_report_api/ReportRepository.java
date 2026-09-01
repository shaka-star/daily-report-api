package com.example.daily_report_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
// JpaRepositoryを継承するだけで、save(),findAll(),,findById(),deleteById()などの基本操作が自動的に使える
}
