package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "professor")
public class Professor {

	public Professor() {}
	
	public Professor(String nome, String sobrenome, String titulo, List<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.titulo = titulo;
		this.disciplinas = disciplinas;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView(View.Disciplina.class)
	private Long id;
	
    @Column(name = "nome", nullable = false)
	@JsonView(View.Disciplina.class)
	private String nome;
    
    @Column(name = "sobrenome", nullable = true)
	@JsonView(View.Disciplina.class)
    private String sobrenome;
    
    @Column(name = "titulo")
	@JsonView(View.Disciplina.class)
    private String titulo;
    
    @OneToMany(mappedBy = "professor", targetEntity = Disciplina.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
    
    
	
}
