package ru.geekbrains.boot;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.boot.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
