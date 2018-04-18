package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Professor;

public interface DisciplinaService {
	
	public List<Disciplina> findAllDisciplinas();
	
	public void exemploTransacao();
		
	public List<Disciplina> buscaDisciplinaProfessor(String nome);
	
	public List<Disciplina> findByProfessorNome(String nome);

	public void saveDisciplina(Disciplina d);
	
	public Disciplina findByNome(String nome);
	
	public Disciplina findBySemestre(String semestre);
	
	public Disciplina findByNomeAndSemestre(String nome, String semestre);
	
	public Disciplina findById(long id);

	
	//public Professor buscaProfessor(String nome);
	
	//public Professor findByDisciplinasDiscNomBte(String nome);
	
	//public void saveProfessor(Professor p);
	
	

}
