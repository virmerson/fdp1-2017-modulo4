package br.com.fabrideprogramador.web2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabrideprogramador.web2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
