package com.projetointegradorg3.redeSocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "postagem")

public class Postagem {

	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 

@NotNull
@Size(max = 15)
private String aprender; 

@NotNull
@Size(max = 15)
private String ensinar;


private boolean didatica;


private int pontosDeExperiencia;

	
	
}
