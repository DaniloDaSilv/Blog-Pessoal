package org.genration.blogPessoal.repository;

import java.util.List;

import org.genration.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
