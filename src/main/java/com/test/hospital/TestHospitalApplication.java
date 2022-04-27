package com.test.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Properties;

@Configuration
@SpringBootApplication
@EntityScan("com.test.hospital.dao") // path of the entity model
@EnableJpaRepositories("com.test.hospital.repository") // path of jpa repository
public class TestHospitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestHospitalApplication.class, args);
	}

}
