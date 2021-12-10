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

import com.projetointegradorg3.redeSocial.model.Postagem;
import com.projetointegradorg3.redeSocial.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping("/all")
	public List<Postagem> getAll(){
		return repository.findAll();
	}
	
	@PostMapping("/save")
	public Postagem post(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@PutMapping("/update")
	public Postagem put(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
