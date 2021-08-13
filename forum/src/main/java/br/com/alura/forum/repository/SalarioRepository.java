package br.com.alura.forum.repository;

import br.com.alura.forum.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends  JpaRepository<Professor, Integer> {


}
