package es.grupo12.pixeltrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication(scanBasePackages = "es.grupo12")
@EnableJpaRepositories(basePackages = "es.grupo12.repository")
@EntityScan(basePackages = "es.grupo12.model")
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)

public class PixeltradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixeltradeApplication.class, args);
	}

}