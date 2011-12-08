package br.com.gedweb.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gedweb.modelo.Solicitacao;

@ManagedBean(name = "controladorSolicitacao")
@SessionScoped
public class ControladorSolicitacao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	private List<Solicitacao> Solicitacoes;
	private Solicitacao solicitacaoSelecionada;
	private Boolean editar;

	public ControladorSolicitacao() {
	}

	public void setSolicitacaoSelecionada(Solicitacao solicitacaoSelecionada) {
		this.solicitacaoSelecionada = solicitacaoSelecionada;
	}

	public Solicitacao getSolicitacaoSelecionada() {
		return solicitacaoSelecionada;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		Solicitacoes = solicitacoes;
	}

	public List<Solicitacao> getSolicitacoes() {
		return Solicitacoes;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Boolean getEditar() {
		return editar;
	}

}