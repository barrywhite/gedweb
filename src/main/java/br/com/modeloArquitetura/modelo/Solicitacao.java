package br.com.modeloArquitetura.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TA_SOLICITACAO")
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLICITACAO")
	private Integer id;

	@ManyToOne
	private Pessoa solicitante;

	@ManyToOne
	private Pessoa atendente;

	public Solicitacao() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	public Pessoa getAtendente() {
		return atendente;
	}

	public void setAtendente(Pessoa atendente) {
		this.atendente = atendente;
	}

}
