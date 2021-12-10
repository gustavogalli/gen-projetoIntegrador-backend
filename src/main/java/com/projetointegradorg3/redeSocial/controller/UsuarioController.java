package com.projetointegradorg3.redeSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegradorg3.redeSocial.model.Usuario;
import com.projetointegradorg3.redeSocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/all")
	public List<Usuario> getAll(){
		return repository.findAll();
	}
	
	@PostMapping("/save")
	public Usuario post (@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping("/update")
	public Usuario put (@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
