package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> { //Postagem = tabela, Long = id (tipo)

	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo); //esse titulo está "vindo" da model, entao tem que estar escrito do mesmo jeito que está lá
	
	
}
