package com.univille.vsp.repositorio;

import com.univille.vsp.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByNomeAndEmail(String nome, String email);

}
