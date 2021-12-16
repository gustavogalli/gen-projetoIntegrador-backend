package com.projetointegradorg3.redeSocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(max = 30)
	private String aprender;

	@Size(max = 30)
	private String ensinar;

	private boolean didatica;

	private int pontosDeExperiencia;

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAprender() {
		return aprender;
	}

	public void setAprender(String aprender) {
		this.aprender = aprender;
	}

	public String getEnsinar() {
		return ensinar;
	}

	public void setEnsinar(String ensinar) {
		this.ensinar = ensinar;
	}

	public boolean isDidatica() {
		return didatica;
	}

	public void setDidatica(boolean didatica) {
		this.didatica = didatica;
	}

	public int getPontosDeExperiencia() {
		return pontosDeExperiencia;
	}

	public void setPontosDeExperiencia(int pontosDeExperiencia) {
		this.pontosDeExperiencia = pontosDeExperiencia;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
