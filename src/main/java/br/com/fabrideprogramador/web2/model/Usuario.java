package br.com.fabrideprogramador.web2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

@NamedQueries(
        {
                @NamedQuery(name = "Usuario.buscarPorPerfil", query = "select  new Usuario(u.id ,  u.nome)   from Usuario u where u.perfil.descricao= ?1")
        }
)
public class Usuario {
    @Id
    @GeneratedValue(generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
    private Integer id;
    private String nome;
    private String senha;

    @JoinColumn
    @ManyToOne
    private Perfil perfil;

    public Usuario() {

    }

    public Usuario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
