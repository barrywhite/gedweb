package br.com.gedweb.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gedweb.crud.CrudGenerico;
import br.com.gedweb.modelo.Solicitacao;
import br.com.gedweb.modelo.TipoSolicitacao;

@ManagedBean(name = "controladorSolicitacao")
@SessionScoped
public class ControladorSolicitacao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	private EntityManager em = emf.createEntityManager();

	@SuppressWarnings("rawtypes")
	private CrudGenerico crud = null;
	private List<Solicitacao> Solicitacoes;
	private Solicitacao solicitacaoSelecionada;
	private TipoSolicitacao tipoSolicitacaoSelecionada;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TipoSolicitacao> getTiposSolicitacao() {
		crud = new CrudGenerico(TipoSolicitacao.class, em);
		return crud.buscarTodos();
	}

	public void setTipoSolicitacaoSelecionada(TipoSolicitacao tipoSolicitacaoSelecionada) {
		this.tipoSolicitacaoSelecionada = tipoSolicitacaoSelecionada;
	}

	public TipoSolicitacao getTipoSolicitacaoSelecionada() {
		return tipoSolicitacaoSelecionada;
	}

}