//Jetty
package br.gov.sp.fatec;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.service.DisciplinaService;


public class App 
{

	public static void main( String[] args )
    {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		DisciplinaService seg = (DisciplinaService)context.getBean("segurancaService");
		
	    
		//transação de inserção dos dados no BD
		seg.exemploTransacao();
		
		
		//Metodo @Query que retorna as disciplinas de um Professor dado o seu nome  
		
		List<Disciplina> d = seg.buscaDisciplinaProfessor("Paulo3");
		
		System.out.println("O professor Paulo3 leciona as seguintes disciplinas: ");
		for (Disciplina d2: d)
			System.out.println(d2.getNome());
	
		List<Disciplina> d3 = seg.findByProfessorNome("Paulo3");
		
		//Metodo QueryMethods que retorna as disciplinas de um Professor dado o seu nome  
		System.out.println("O professor Paulo3 leciona as seguintes disciplinas: ");
		for (Disciplina a: d3)
			System.out.println(a.getNome());
	
		/*Metodo @Query que retorna o nome do professor, dado o nome de uma determinada disciplina
		System.out.println("A disicplina Matematica é ministrada pelo professor " + seg.buscaProfessor("Matematica").getNome());
		
		//Metodo QueryMethods que retorna o nome do professor, dado o nome de uma determinada disciplina
		System.out.println("A disicplina Matematica é ministrada pelo professor " + seg.findByDisciplinasDiscNome("Matematica").getNome());
		 */
    }
}