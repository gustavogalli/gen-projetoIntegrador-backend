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
import com.projetointegradorg3.redeSocial.model.Tema;
import com.projetointegradorg3.redeSocial.repository.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin ("*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping("/all")
	public List<Tema> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Tema findById(@PathVariable long id) {
		return repository.getById(id);
	}
	
	@GetMapping("curso/{curso}")
	public List<Tema> findByCursoContainingIgnoreCase(@PathVariable String curso) {
		return repository.findByCursoContainingIgnoreCase(curso);
	}

	@PostMapping("/save")
	public Tema post(@RequestBody Tema tema) {
		return repository.save(tema);
	}

	@PutMapping("/update")
	public Tema put(@RequestBody Tema tema) {
		return repository.save(tema);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}


}
