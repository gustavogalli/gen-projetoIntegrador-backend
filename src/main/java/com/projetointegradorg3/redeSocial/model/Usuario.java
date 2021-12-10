package com.projetointegradorg3.redeSocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
 * - email: representa o email que será utilizado para acessar;
 * </p>
 * 
 * <p>
 * - senha: representa a senha de acesso do usuário;
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
	private long id;

	@NotBlank
	@Size(min = 5, max = 50)
	private String nome;

	@NotBlank
	@Size(min = 5, max = 45)
	@Email
	private String email;

	@NotBlank
	@Size(min = 8, max = 20)
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}
