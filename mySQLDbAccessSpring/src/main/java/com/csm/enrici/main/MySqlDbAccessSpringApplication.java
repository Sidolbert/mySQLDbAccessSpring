package com.csm.enrici.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//si vous faites des packages séparés, précisez-les pour que l'appli détecte les composants
@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.csm.enrici.main", "com.csm.enrici.model"})
@ComponentScan(basePackages = {"com.csm.enrici.main", "com.csm.enrici.model"})
public class MySqlDbAccessSpringApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(MySqlDbAccessSpringApplication.class, args);
	}

}
