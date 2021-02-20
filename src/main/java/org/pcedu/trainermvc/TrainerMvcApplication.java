package org.pcedu.trainermvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication (exclude = HibernateJpaAutoConfiguration.class)
public class TrainerMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerMvcApplication.class, args);
	}

}
