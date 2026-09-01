package com.example.daily_report_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class DailyReportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyReportApiApplication.class, args);
	}

}
