package com.cg.ows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.ows.repository")
public class OnlineWalletSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineWalletSystemApplication.class, args);
	}

}
