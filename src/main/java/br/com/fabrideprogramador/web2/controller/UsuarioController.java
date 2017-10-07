package br.com.fabrideprogramador.web2.controller;

import java.util.List;

import br.com.fabrideprogramador.web2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fabrideprogramador.web2.model.Usuario;

@RestController
@RequestMapping("/usucontroller")
@CrossOrigin(origins = {"*"} )
public class UsuarioController {



	@Autowired
	private UsuarioService  usuarioService;


	@PostMapping
	public Usuario inserir(@RequestBody Usuario usuario){

		return usuarioService.salvar(usuario);
	}
	
	@PutMapping
	public Usuario alterar(@RequestBody Usuario usuario){


		return usuarioService.salvar(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id){
		usuarioService.excluir(id);
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable("id") Integer id){
		return usuarioService.buscarPorId(id);
	}
	@GetMapping("/q/{nome}")
	public List<Usuario> buscarPorNome(@PathVariable("nome")  String nome){
		return usuarioService.buscarPorNome(nome);
	}

	@GetMapping("/q2")
	public List<Usuario> buscarPorNomeESenha(@RequestParam("nome") String nome, @RequestParam("senha") String senha){
		return usuarioService.buscarPorNomeESenha(nome, senha);
	}


	@PostMapping ("/autenticar")
	public List<Usuario> autenticar(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
		List<Usuario> l  =  usuarioService.buscarPorNomeESenha(usuario.getNome(),usuario.getSenha());

		if  (l==null || l.size()==0){
			throw new UsuarioNaoEncontradoException();
		}else {
			return l;
		}
	}


	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioService.buscarTodos();
	}

	@GetMapping ("/q/perfil")
	List<Usuario> buscarPorPerfil(@RequestParam("descricao") String descricao ){
		return usuarioService.buscarPorPerfil(descricao);
	}

}
