package com.univille.vsp;

import com.univille.vsp.entidade.Usuario;
import com.univille.vsp.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class VspApplication {

	public static void main(String[] args) {
		SpringApplication.run(VspApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UsuarioRepository repo)
	{
		return args -> {
			repo.save(new Usuario("vini", "vinicrezende@gmail.com",
					"mako", LocalDateTime.now()));

			for (Usuario u : repo.findAll()) {
				System.out.printf("%d: %s - %s.\n", u.getId(), u.getNome(), u.getEmail());
			}
		};
	}

}
