package br.com.modeloArquitetura.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.modelo.Solicitacao;

@ManagedBean(name = "controladorSolicitacao")
@SessionScoped
public class ControladorSolicitacao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	private Solicitacao solicitacao;
	private DataModel<Solicitacao> listaSolicitacoes;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adicionar() {
		CrudGenerico crud = new CrudGenerico(Solicitacao.class, this.em);
		crud.adicionar(solicitacao);
		return "solicitacao-list";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String alterar() {
		CrudGenerico crud = new CrudGenerico(Solicitacao.class, this.em);
		crud.alterar(solicitacao);
		return "solicitacao-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excluir() {
		CrudGenerico crud = new CrudGenerico(Solicitacao.class, this.em);
		crud.excluir(listaSolicitacoes.getRowData());
		return "solicitacao-list";
	}

	public String prepararAdicionar() {
		solicitacao = new Solicitacao();
		return "solicitacao";
	}

	public String prepararAlterar() {
		solicitacao = listaSolicitacoes.getRowData();
		return "solicitacao";
	}

	public String prepararExcluir() {
		solicitacao = listaSolicitacoes.getRowData();
		return "solicitacao";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae) {
		CrudGenerico crud = new CrudGenerico(Solicitacao.class, this.em);
		crud.buscarPorFiltro(this.solicitacao);

		this.solicitacao = new Solicitacao();
	}

	public DataModel<Solicitacao> buscarTodos() {
		return getListarSolicitacoes();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel<Solicitacao> getListarSolicitacoes() {
		CrudGenerico crud = new CrudGenerico(Solicitacao.class, this.em);
		listaSolicitacoes = new ListDataModel<Solicitacao>(crud.buscarTodos());
		return listaSolicitacoes;
	}

	public void salvar() {

	}

	public Solicitacao getSolicitacao(){
		return solicitacao;
	}
	
	public void setSolicitacao(Solicitacao solicitacao){
	}
	
}