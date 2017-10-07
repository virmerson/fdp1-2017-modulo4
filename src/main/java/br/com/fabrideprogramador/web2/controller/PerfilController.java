package br.com.fabrideprogramador.web2.controller;

import br.com.fabrideprogramador.web2.model.Perfil;
import br.com.fabrideprogramador.web2.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 02/09/17.
 */
@CrossOrigin(origins = {"*"} )
@RestController
@RequestMapping("/perfilcontroller")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    public Perfil cadastrar(@RequestBody Perfil perfil){
       return  perfilRepository.save(perfil);
    }

    @GetMapping
    public List<Perfil> buscarTodos(){
        return perfilRepository.findAll();
    }

}
