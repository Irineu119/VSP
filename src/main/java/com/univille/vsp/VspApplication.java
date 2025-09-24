package com.univille.vsp;

import com.univille.vsp.entidade.Categoria;
import com.univille.vsp.entidade.Usuario;
import com.univille.vsp.entidade.Video;
import com.univille.vsp.repositorio.CategoriaRepository;
import com.univille.vsp.repositorio.UsuarioRepository;
import com.univille.vsp.repositorio.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
public class VspApplication {

	public static void main(String[] args) {
		SpringApplication.run(VspApplication.class, args);
	}

	@Bean
	CommandLineRunner runUsuario(UsuarioRepository repo) {
		return args -> {
            if (repo.count() == 0) {
                repo.save(new Usuario("vinicius", "vinicius.rezende@univille.br", "123abc", LocalDateTime.now()));
                repo.save(new Usuario("murilo", "murilo.hinckel@univille.br", "987zyx", LocalDateTime.now()));
                repo.save(new Usuario("leonardo", "leonardo.winters@univille.br", "qwerty", LocalDateTime.now()));
            }

			for (Usuario u : repo.findAll()) {
				System.out.printf("%d: %s - %s.\n", u.getId(), u.getNome(), u.getEmail());
			}
		};
	}

    @Bean
    CommandLineRunner runVideo(VideoRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                //repo.save(new Video("Teste", "teste", 30, ));
            }

            Scanner s = new Scanner(System.in);
            System.out.print("Pesquisar vídeos por título: ");
            String titulo = s.nextLine();
            System.out.printf("Videos com '%s' no nome sorteados:\n", titulo);
            for (Video v : repo.findByTituloContaining(titulo, Sort.by("titulo"))) {
                System.out.printf("%d: %s - %s (%d segundos).\n", v.getId(), v.getTitulo(), v.getDescricao(), v.getDuracao());
            }
        };
    }

    @Bean
    CommandLineRunner runCategoria(CategoriaRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Categoria("Entretenimento"));
                repo.save(new Categoria("Educação"));
                repo.save(new Categoria("Música"));
            }
        };
    }

}
