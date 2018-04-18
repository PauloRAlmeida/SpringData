/*package br.sp.gov.fatec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.repository.DisciplinaRepository;
import br.gov.sp.fatec.repository.ProfessorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" } )
@Transactional

public class DisciplinaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private DisciplinaRepository discRepo;
	@Autowired
	private ProfessorRepository profRepo;
	
	public void setDisciplinaRepository(DisciplinaRepository discRepo) {
		this.discRepo = discRepo;
	}
	
	@Test
	public void disicplinaInsertTest() {
		Disciplina disc = new Disciplina();
		disc.setNome("Matematica");
		disc.setSemestre("5");
		discRepo.save(disc);
		assertNotNull(discRepo.findByNome("Matematica"));
	}
	

	@Test
	public void disciplinaDeleteTest() {
		Disciplina disc = new Disciplina();
		disc.setNome("Ingles");
		disc.setSemestre("5");
		discRepo.save(disc);
		discRepo.delete(discRepo.findByNome("Ingles"));
		assertNull(discRepo.findByNome("Ingles"));
	}
	
	@Test
	public void disciplinaUpdateTest() {
		Disciplina disc = new Disciplina();
		disc.setNome("Ingles");
		disc.setSemestre("5");
		discRepo.save(disc);
		Disciplina d = discRepo.findByNome("Ingles");
		d.setNome("Matematica");
		discRepo.save(d);
		assertTrue(discRepo.findAll().iterator().next().getNome().equals("Matematica"));
	}
	
	@Test
	public void findByProfessorNomeTest() {
		Professor p = new Professor();
		p.setNome("Paulo");
		p.setSobrenome("Rangel");
		p.setTitulo("Mestre");
		Disciplina disc = new Disciplina();
		disc.setNome("Estatistica");
		disc.setSemestre("2");
		disc.setProfessor(p);
		profRepo.save(p);
		discRepo.save(disc);
		assertTrue(discRepo.buscaDisciplinaProfessor("Paulo").iterator().next().getNome().equals("Estatistica"));
		
	}
	
	/*
	@Test
	public void disiciplinaInsertTest2() {
		assertNull(discRepo.findByNome("Ingles"));
	}

}

*/
