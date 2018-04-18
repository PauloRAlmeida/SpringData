package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina,Long> {

	@Query ("Select d from Disciplina d join d.professor p where p.nome = :nome")
	public List<Disciplina> buscaDisciplinaProfessor(@Param("nome") String nome);
	
	public List<Disciplina> findByProfessorNome(String nome);

	public Disciplina findByNome(String nome);
	
	public Disciplina findById(long id);
	
	public Disciplina findBySemestre(String semestre);
	
	public Disciplina findByNomeAndSemestre(String nome, String semestre);

}
