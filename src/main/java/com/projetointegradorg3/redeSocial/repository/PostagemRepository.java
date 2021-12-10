package com.projetointegradorg3.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class PostagemRepository {

	@Repository
	public interface Postagem  extends JpaRepository<Postagem, Long>{
		
		public List<Postagem>findByAprenderContainingIgnoreCase(String aprender);
	}
}