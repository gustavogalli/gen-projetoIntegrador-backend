package com.projetointegradorg3.redeSocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tema")
public class Tema {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotBlank
@Size(max = 15)
private String curso; 

@NotNull
private int pontosAprender;


@NotNull
private int pontosEnsinar;


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
