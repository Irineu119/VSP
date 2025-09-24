package com.univille.vsp.repositorio;

import com.univille.vsp.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Categoria findByNome();

}
