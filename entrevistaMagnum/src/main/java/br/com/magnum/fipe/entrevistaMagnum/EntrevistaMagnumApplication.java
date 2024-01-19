package br.com.magnum.fipe.entrevistaMagnum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EntrevistaMagnumApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrevistaMagnumApplication.class, args);
	}

}
