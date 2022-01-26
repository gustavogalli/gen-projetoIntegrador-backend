package com.projetointegradorg3.redeSocial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p>
 * - id: representa a coluna de id do usuário. Essa coluna é gerada
 * automaticamente e possui AUTO_INCREMENT.
 * </p>
 * 
 * <p>
 * - nome: representa o nome completo do usuário;
 * </p>
 * 
 * <p>
 * - usuario: representa o usuários que será utilizado para acessar;
 * </p>
 * 
 * <p>
 * - email: representa o email que também poderá será utilizado para acessar;
 * </p>
 * 
 * <p>
 * - senha: representa a senha de acesso do usuário;
 * </p>
 * 
 * <p>
 * - foto: representa a foto do usuário;
 * </p>
 * 
 * <p>
 * - tipo: representa se o usuário é administrador ou usuário normal;
 * </p>
 * 
 * @author Caio Gabriel
 * @author Gustavo Galli
 * @author João Almeida
 * @author Raphaella Guerra
 * @since 1.0
 *
 */

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 8, max = 50)
	private String nome;

	@NotNull
	@Size(min = 3, max = 25)
	private String usuario;

	@NotNull
	@Email
	@Size(min = 5, max = 50)
	private String email;

	@NotNull
	@Size(min = 5)
	private String senha;

	private String foto;
	
	private String tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")

	private List<Postagem> postagem = new ArrayList<>();

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
}