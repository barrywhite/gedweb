package br.com.gedweb.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TA_FUNCIONARIO")
@PrimaryKeyJoinColumn(name="ID_PESSOA", referencedColumnName="ID_PESSOA")
public class Funcionario extends Pessoa{

	@Column(name="SALARIO", length = 5)
	private float salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ADMISSAO", length = 10)
	private Date dataAdmissao;	
	
	@Column(name="CARGO", length = 30)
	private String cargo;	
	
	@ManyToOne	
	private Departamento departamento;
	
	public Funcionario() {
		
	}

	public Funcionario(float salario, Date dataAdmissao, String cargo,
			Departamento departamento, String login, String senha) {
		super();
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.cargo = cargo;
		this.departamento = departamento;
		this.setLogin(login);
		this.setSenha(senha);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	
}
