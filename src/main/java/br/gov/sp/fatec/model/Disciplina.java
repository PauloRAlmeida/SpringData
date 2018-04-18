package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name = "disciplina")

public class Disciplina{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView(View.Disciplina.class)
	@XmlElement
	private Long id;
	
    @Column(name = "nome", unique = true)
	@JsonView({View.Disciplina.class, View.Alternative.class})
    @XmlElement
	private String nome;
    
    @Column(name = "semestre")
	@JsonView({View.Disciplina.class, View.Alternative.class})
    @XmlElement
    private String semestre;
 
    @ManyToOne 
    @JoinColumn (name="professor")
    @JsonView(View.Disciplina.class)
    private Professor professor;

    //@Column(name = "aluno_nome", length = 20, nullable = true)
    //private String nomeAluno;
 
    //public String getNomeAluno() {
  	//	return nomeAluno;
  	//}

  	//public void setNomeAluno(String nomeAluno) {
  	//	this.nomeAluno = nomeAluno;
  	//}

    
    public String getNome() {
		return nome;
	}

	public void setNome(String discNome) {
		this.nome = discNome;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semetre) {
		this.semestre = semetre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
}
