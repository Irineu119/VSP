package com.univille.vsp.repositorio;

import com.univille.vsp.entidade.Avaliacao;
import com.univille.vsp.entidade.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
