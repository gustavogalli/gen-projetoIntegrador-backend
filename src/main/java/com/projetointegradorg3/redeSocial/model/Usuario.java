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
 * - usuario: representa o usuário que será utilizado para acessar;
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
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo Nome é Obrigatório!")
	private String nome;

	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caractéres")
	private String foto;

	private String tipo;

	@NotNull(message = "O atributo Usuário é Obrigatório!")
	private String usuario;

	@NotBlank(message = "O atributo Senha é Obrigatório!")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Usuario(Long id, String nome, String foto, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario() {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}