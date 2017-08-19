package br.com.fabrideprogramador.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabrideprogramador.web2.model.Usuario;
import br.com.fabrideprogramador.web2.repository.UsuarioRepository;

@RestController(value="/usucontroller")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	public Usuario inserir(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping
	public Usuario alterar(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id){
		usuarioRepository.delete(id);
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable("id") Integer id){
		return usuarioRepository.findOne(id);
	}
	
	@GetMapping("/todos")
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	
}
