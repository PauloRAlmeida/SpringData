package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor,String> {
	
	@Query("Select p from Professor p join p.disciplinas d where d.nome = :nome")
	public Professor buscaProfessor(@Param("nome") String nome);
	
	public Professor findByDisciplinasNome(String nome);
	
	
}
