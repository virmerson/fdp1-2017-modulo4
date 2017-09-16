package br.com.fabrideprogramador.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import br.com.fabrideprogramador.web2.model.Usuario;
import br.com.fabrideprogramador.web2.repository.UsuarioRepository;

@RestController
@RequestMapping("/usucontroller")
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
	@GetMapping("/q/{nome}")
	public List<Usuario> buscarPorNome(@PathVariable("nome")  String nome){
		return usuarioRepository.findByNomeIgnoreCase(nome);
	}

	@GetMapping("/q2")
	public List<Usuario> buscarPorNomeESenha(@RequestParam("nome") String nome, @RequestParam("senha") String senha){
		return usuarioRepository.findByNomeAndSenha(nome, senha);
	}


	@PostMapping ("/autenticar")
	public List<Usuario> autenticar(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
		List<Usuario> l  =  usuarioRepository.findByNomeAndSenha(usuario.getNome(),usuario.getSenha());

		if  (l==null || l.size()==0){
			throw new UsuarioNaoEncontradoException();
		}else {
			return l;
		}
	}


	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}

	@GetMapping ("/q/perfil")
	List<Usuario> buscarPorPerfil(@RequestParam("descricao") String descricao ){
		return usuarioRepository.buscarPorPerfil(descricao);
	}

}
