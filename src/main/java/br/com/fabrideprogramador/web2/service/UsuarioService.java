package br.com.fabrideprogramador.web2.service;

import br.com.fabrideprogramador.web2.model.Perfil;
import br.com.fabrideprogramador.web2.model.Usuario;
import br.com.fabrideprogramador.web2.repository.PerfilRepository;
import br.com.fabrideprogramador.web2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 07/10/17.
 */
@Service
public class UsuarioService  {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private PerfilRepository perfilRepository;



    public Usuario salvar (Usuario usuario){

        if (usuario.getPerfil()==null){
            Perfil perfilPadrao = perfilRepository.findOne(2);
            usuario.setPerfil(perfilPadrao);
        }
      return  usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) {
     usuarioRepository.delete(id);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeIgnoreCase(nome);
    }

    public List<Usuario> buscarPorNomeESenha(String nome, String senha) {
        return usuarioRepository.findByNomeAndSenha(nome, senha);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findOne(id);
    }


    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarPorPerfil(String descricao) {
        return usuarioRepository.findByPerfilDescricao(descricao);
    }
}
