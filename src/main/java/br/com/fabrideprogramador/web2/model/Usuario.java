package br.com.fabrideprogramador.web2.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
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
}
