package br.com.fabrideprogramador.web2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabrideprogramador.web2.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


     List<Usuario> findByNomeIgnoreCase(String nome);

    List<Usuario> findByNomeAndSenha(String nome, String senha);
}
