package com.projetointegradorg3.redeSocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(max = 30)
	private String curso;

	@NotNull
	private int pontosAprender;

	@NotNull
	private int pontosEnsinar;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("pontosDeExperiencia")
	private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPontosAprender() {
		return pontosAprender;
	}

	public void setPontosAprender(int pontosAprender) {
		this.pontosAprender = pontosAprender;
	}

	public int getPontosEnsinar() {
		return pontosEnsinar;
	}

	public void setPontosEnsinar(int pontosEnsinar) {
		this.pontosEnsinar = pontosEnsinar;
	}

}
