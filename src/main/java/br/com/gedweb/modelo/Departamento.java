package br.com.gedweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TA_DEPARTAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DEPARTAMENTO")
	private Integer id;
	
	@Column(name = "NOME", length = 100)
	private String nome;
	
	@OneToMany
	@JoinColumn(name = "ID_PESSOA")  
	private List<Funcionario> funcionarios;
	
	public Departamento() {
		super();
	}

	public Departamento(Integer id, String nome, List<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcionarios = funcionarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
