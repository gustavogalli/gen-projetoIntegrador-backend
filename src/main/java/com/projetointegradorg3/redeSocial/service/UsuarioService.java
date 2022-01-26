package com.projetointegradorg3.redeSocial.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projetointegradorg3.redeSocial.model.Usuario;
import com.projetointegradorg3.redeSocial.model.UsuarioLogin;
import com.projetointegradorg3.redeSocial.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		Optional<Usuario> optionalemail = repository.findByEmail(usuario.getEmail());
		Optional<Usuario> optionalusuario = repository.findAllByUsuario(usuario.getUsuario());
		if (optionalemail.isEmpty() && optionalusuario.isEmpty()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String senhaencoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaencoder);

			return repository.save(usuario);
		} else if (optionalemail.isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email já existente");
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuário já existente");
		}
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> email = repository.findByEmail(user.get().getEmail());
		Optional<Usuario> usuario = repository.findAllByUsuario(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setUsuario(usuario.get().getUsuario());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta!");
			}
		} else if (email.isPresent()) {
			if (encoder.matches(user.get().getSenha(), email.get().getSenha())) {
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setId(email.get().getId());
				user.get().setNome(email.get().getNome());
				user.get().setFoto(email.get().getFoto());
				user.get().setTipo(email.get().getTipo());
				user.get().setEmail(email.get().getEmail());

				return user;
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta!");
			}
		} else {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email ou usuário incorreto!");
		}
	}
}