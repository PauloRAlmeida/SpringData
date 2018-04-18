/*
package br.sp.gov.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.service.SegurancaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" } )
@Transactional
public class SegurancaServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	
	@Autowired
	private SegurancaService seg;
	
	@Test
	public void buscaProfessorTest() {
		Professor p = new Professor();
		p.setNome("Paulo");
		p.setSobrenome("Rangel");
		p.setTitulo("Mestre");
		Disciplina disc = new Disciplina();
		disc.setNome("Estatistica");
		disc.setSemestre("2");
		disc.setProfessor(p);
		seg.saveProfessor(p);
		seg.saveDisciplina(disc);
		assertTrue(seg.buscaProfessor("Estatistica").getNome().equals("Paulo"));
	}

	
}
*/