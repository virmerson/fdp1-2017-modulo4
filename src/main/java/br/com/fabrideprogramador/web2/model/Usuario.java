package br.com.fabrideprogramador.web2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String senha;
}
