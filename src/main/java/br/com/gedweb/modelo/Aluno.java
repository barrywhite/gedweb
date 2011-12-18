package br.com.gedweb.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn(name="ID_PESSOA", referencedColumnName="ID_PESSOA")
public class Aluno extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "TURMA", length = 100)
	private String turma;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_MATRICULA", length = 10)
	private Date dataMatricula;
	
	@Column(name = "MENSALIDADE", length = 5)
	private float mensalidade;

	public Aluno() {
		
	}

	public Aluno( String turma, Date dataMatricula,
			float mensalidade, String login, String senha) {
		super();
		this.turma = turma;
		this.dataMatricula = dataMatricula;
		this.mensalidade = mensalidade;
		this.setLogin(login);
		this.setSenha(senha);
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	
}
