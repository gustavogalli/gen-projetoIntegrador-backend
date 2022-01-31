package com.projetointegradorg3.redeSocial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetointegradorg3.redeSocial.model.Postagem;
import com.projetointegradorg3.redeSocial.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id não existente"));
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/save")
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(201).body(repository.save(postagem));
	}

	@PutMapping("/update")
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(200).body(repository.save(postagem));
	}

	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
