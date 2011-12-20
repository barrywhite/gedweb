package br.com.gedweb.controlador;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.gedweb.dao.DepartamentoDao;
import br.com.gedweb.dao.PessoaDao;
import br.com.gedweb.dao.SolicitacaoDao;
import br.com.gedweb.dao.TipoSolicitacaoDao;
import br.com.gedweb.dao.TramiteDao;
import br.com.gedweb.modelo.Departamento;
import br.com.gedweb.modelo.Pessoa;
import br.com.gedweb.modelo.Solicitacao;
import br.com.gedweb.modelo.TipoSolicitacao;
import br.com.gedweb.modelo.Tramite;

@ManagedBean(name = "controladorTramitacao")
@SessionScoped
public class ControladorTramitacao {

	private Solicitacao solicitacao;
	private Departamento departamento;
	private TipoSolicitacaoDao tipoSolicitacaoDao;
	private SolicitacaoDao solicitacaoDao;
	private PessoaDao pessoaDao;
	private DepartamentoDao departamentoDao;
	private TramiteDao tramiteDao;
	private Tramite tramiteSelecionado;

	public ControladorTramitacao() {
		tipoSolicitacaoDao = new TipoSolicitacaoDao();
		departamento = new Departamento();
		solicitacaoDao = new SolicitacaoDao();
		pessoaDao = new PessoaDao();
		solicitacao = new Solicitacao();
		departamentoDao = new DepartamentoDao();
		tramiteDao = new TramiteDao();
	}

	public List<TipoSolicitacao> getTiposSolicitacao() {
		return tipoSolicitacaoDao.buscarTodos();
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

	public void removerSolicitante(ActionEvent e) {
		solicitacao.setSolicitante(new Pessoa());
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void removerDepartamento(ActionEvent e) {
		this.departamento = null;
	}

	public List<Departamento> getDepartamentos() {
		return departamentoDao.buscarTodos();
	}

	public void removerAtendente(ActionEvent e) {
		this.solicitacao.setAtendente(new Pessoa());
	}

	public String adicionarSolicitacao() {
		Tramite tramite = new Tramite();
		tramite.setDepartamento(departamento);
		solicitacao.getTramites().add(tramite);
		solicitacaoDao.adicionar(solicitacao);
		tramite.setSolicitacao(solicitacao);
		tramiteDao.adicionar(tramite);
		return "solicitacao-list";
	}

	public String visualizar() {
		return "tramitacao";
	}

	public String voltar() {
		return "tramitacao-list";
	}

	public void setTramiteSelecionado(Tramite tramiteSelecionado) {
		this.tramiteSelecionado = tramiteSelecionado;
	}

	public Tramite getTramiteSelecionado() {
		return tramiteSelecionado;
	}

	public void removerTramitacao(ActionEvent e) {
		if (!solicitacao.getTramites().contains(tramiteSelecionado)) {
			solicitacao.getTramites().remove(tramiteSelecionado);
		}
	}

	@SuppressWarnings("deprecation")
	public void adicionarTramitacao(ActionEvent e) {
		Tramite tramite = new Tramite() ;
		if (!solicitacao.getTramites().isEmpty()) {
			tramite = solicitacao.getTramites().get(solicitacao.getTramites().size() - 1);
			tramite.setDataSaida(new Date(2011,12,11));
			tramiteDao.alterar(tramite);
		}
		tramite.setDataEntrada(new Date(2011,12,11));
		tramite.setAtendente(solicitacao.getAtendente());
		tramite.setDepartamento(departamento);

		if (!solicitacao.getTramites().contains(tramite)) {
			solicitacao.getTramites().add(tramite);
		}
		tramiteDao.adicionar(tramite);
	}
}