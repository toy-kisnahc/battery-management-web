package com.kisnahc.batterymanagementweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BatteryManagementWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatteryManagementWebApplication.class, args);
	}

}
