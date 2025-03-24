package ru.netology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class DAOHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DAOHibernateApplication.class, args);
	}
}
