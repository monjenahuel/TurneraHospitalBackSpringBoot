package com.monjenahuel.sweetmedical;

import com.monjenahuel.sweetmedical.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SweetMedicalApplication {

	public static void main(String[] args) {

		SpringApplication.run(SweetMedicalApplication.class, args);
	}
}


