package br.com.modeloArquitetura.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TA_SOLICITACAO")
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLICITACAO")
	private Integer id;
	
	@Column
	private String justificativa;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Column(name="DATA_CONCLUSAO")
	private Date dataConclusao;
	
	@ManyToMany(mappedBy="solicitacoes")
	private List<TipoSolicitacao> tiposSolicitacao;
	
	@ManyToOne
	private Pessoa solicitante;

	@ManyToOne
	private Pessoa atendente;

	public Solicitacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
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
	
	public List<TipoSolicitacao> getTiposSolicitacao() {
		return tiposSolicitacao;
	}

	public void setTiposSolicitacao(List<TipoSolicitacao> tiposSolicitacao) {
		this.tiposSolicitacao = tiposSolicitacao;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", justificativa=" + justificativa
				+ ", dataCriacao=" + dataCriacao + ", dataConclusao="
				+ dataConclusao + ", solicitante=" + solicitante
				+ ", atendente=" + atendente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atendente == null) ? 0 : atendente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (atendente == null) {
			if (other.atendente != null)
				return false;
		} else if (!atendente.equals(other.atendente))
			return false;
		return true;
	}

}