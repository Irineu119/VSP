package com.univille.vsp.repositorio;

import com.univille.vsp.entidade.Video;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    public List<Video> findByTituloContaining(String titulo, Sort sort);

}
