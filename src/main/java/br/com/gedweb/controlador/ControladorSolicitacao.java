package br.com.gedweb.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.gedweb.dao.PessoaDao;
import br.com.gedweb.dao.SolicitacaoDao;
import br.com.gedweb.dao.TipoSolicitacaoDao;
import br.com.gedweb.modelo.Pessoa;
import br.com.gedweb.modelo.Solicitacao;
import br.com.gedweb.modelo.TipoSolicitacao;

@ManagedBean(name = "controladorSolicitacao")
@SessionScoped
public class ControladorSolicitacao {

	private Solicitacao solicitacao;
	private TipoSolicitacao tipoSolicitacaoSelecionada;
	private TipoSolicitacaoDao tipoSolicitacaoDao;
	private SolicitacaoDao solicitacaoDao;
	private PessoaDao pessoaDao;

	public ControladorSolicitacao() {
		tipoSolicitacaoDao = new TipoSolicitacaoDao();
		solicitacaoDao = new SolicitacaoDao();
		pessoaDao = new PessoaDao();
		solicitacao = new Solicitacao();
	}

	public List<TipoSolicitacao> getTiposSolicitacao() {
		return tipoSolicitacaoDao.buscarTodos();
	}

	public void setTipoSolicitacaoSelecionada(TipoSolicitacao tipoSolicitacaoSelecionada) {
		this.tipoSolicitacaoSelecionada = tipoSolicitacaoSelecionada;
	}

	public TipoSolicitacao getTipoSolicitacaoSelecionada() {
		return tipoSolicitacaoSelecionada;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacaoDao.buscarTodos();
	}

	public List<Pessoa> getPessoas() {
		return pessoaDao.buscarTodos();
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void adicionarObjetivo(ActionEvent e) {
		if (!solicitacao.getTiposSolicitacao().contains(tipoSolicitacaoSelecionada)) {
			solicitacao.getTiposSolicitacao().add(tipoSolicitacaoSelecionada);
		}
	}

	public void removerObjetivo(ActionEvent e) {
		if (solicitacao.getTiposSolicitacao().contains(tipoSolicitacaoSelecionada)) {
			solicitacao.getTiposSolicitacao().remove(tipoSolicitacaoSelecionada);
		}
	}

}