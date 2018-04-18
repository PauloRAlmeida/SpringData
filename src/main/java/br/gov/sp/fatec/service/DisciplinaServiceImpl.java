package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.repository.DisciplinaRepository;
import br.gov.sp.fatec.repository.ProfessorRepository;

@Service("segurancaService")
public class DisciplinaServiceImpl implements DisciplinaService {
	
	@Autowired
	private ProfessorRepository profRepo;
	@Autowired
	private DisciplinaRepository discRepo;
	
	@Transactional
	public void exemploTransacao() {
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("Portugues");
		disciplina.setSemestre("2");
		
		Disciplina d2 = new Disciplina();
		d2.setNome("Matematica");
		d2.setSemestre("3");
		
		Professor professor = new Professor();
		professor.setNome("Paulo3");
		professor.setSobrenome("Rangel3");
		professor.setTitulo("Mestre");
		
		disciplina.setProfessor(professor);
		d2.setProfessor(professor);
		
		
		profRepo.save(professor);
		discRepo.save(disciplina);
		discRepo.save(d2);
		
		}
		
	public Professor buscaProfessor(String nome) {
		return profRepo.buscaProfessor(nome);
	}	
	
	public List<Disciplina> buscaDisciplinaProfessor(String nome) {
		return (List<Disciplina>) discRepo.buscaDisciplinaProfessor(nome);
	}
	
	public List<Disciplina> findByProfessorNome(String nome) {
		return (List<Disciplina>) discRepo.findByProfessorNome(nome);
	}

	public Professor findByDisciplinasDiscNome(String nome) {
		return profRepo.findByDisciplinasNome(nome);
	}
	
	public void setProfessorRepository(ProfessorRepository profRepo) {
		this.profRepo = profRepo;
	}
	public void setDisciplinaRepository(DisciplinaRepository discRepo) {
		this.discRepo = discRepo;
	}

	public void saveProfessor(Professor p) {
		profRepo.save(p);
	}
	
	public void saveDisciplina(Disciplina d) {
		discRepo.save(d);
	}

	public List<Disciplina> findAllDisciplinas() {
		return (List<Disciplina>) discRepo.findAll();
	}

	public Disciplina findByNome(String nome) {
		return discRepo.findByNome(nome);
	}

	public Disciplina findById(long id) {
		return discRepo.findById(id);
	}

	@Override
	public Disciplina findBySemestre(String semestre) {
		return discRepo.findBySemestre(semestre);
	}

	@Override
	public Disciplina findByNomeAndSemestre(String nome, String semestre) {
		return discRepo.findByNomeAndSemestre(nome, semestre);
	}

	
}
