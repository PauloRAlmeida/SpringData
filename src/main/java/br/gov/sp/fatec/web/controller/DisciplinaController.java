
package br.gov.sp.fatec.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.service.DisciplinaService;
import br.gov.sp.fatec.view.View;

@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;

	public void setsegService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		return "Ola, bem vindo";
	}
	
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.Disciplina.class)
	public ResponseEntity<Collection<Disciplina>> pesquisar() {
		return new ResponseEntity<Collection<Disciplina>>(disciplinaService.findAllDisciplinas(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getSome", produces={"application/json", "application/xml"})
	@JsonView(View.Disciplina.class)
	public ResponseEntity<Disciplina> getByNomeSemestre(@RequestParam(value="nome", required = false) String nome, @RequestParam(value="semestre", required = false) String semestre) {
		
		//Caso nenhum argumento seja passado
		if (nome == null && semestre == null)
			return new ResponseEntity<Disciplina>(HttpStatus.PRECONDITION_FAILED);
		
		if(nome == null) {
			Disciplina disc = disciplinaService.findBySemestre(semestre);
			if (disc != null) return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		if(semestre == null) {
			Disciplina disc = disciplinaService.findByNome(nome);
			if (disc != null) return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		
		Disciplina disc = disciplinaService.findByNomeAndSemestre(nome, semestre);
		
		if (disc != null) return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);
		
		return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value = "/getById", produces={"application/json", "application/xml"})
	@JsonView(View.Alternative.class)
	public ResponseEntity<Disciplina> getAll(@RequestParam(value="id", defaultValue="1") int id) {
		Disciplina disc = disciplinaService.findById(id);
		if(disc == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);
	}
	
	
	/*// Voce pode informar o metodo e o tipo de retorno produzido
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	// E possivel indicar o status por anotacao, mas sera fixo, sem possibilidade de tratar erros
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
		usuario = segService.salvar(usuario);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
		return usuario;
	}
	*/
	
}
