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
import br.com.gedweb.enuns.SituacaoSolicitacao;
import br.com.gedweb.modelo.Departamento;
import br.com.gedweb.modelo.Pessoa;
import br.com.gedweb.modelo.Solicitacao;
import br.com.gedweb.modelo.TipoSolicitacao;
import br.com.gedweb.modelo.Tramite;

@ManagedBean(name = "controladorSolicitacao")
@SessionScoped
public class ControladorSolicitacao {

	private Solicitacao solicitacao;
	private TipoSolicitacao tipoSolicitacaoSelecionada;
	private Departamento departamento;
	private TipoSolicitacaoDao tipoSolicitacaoDao;
	private SolicitacaoDao solicitacaoDao;
	private PessoaDao pessoaDao;
	private DepartamentoDao departamentoDao;
	private TramiteDao tramiteDao;

	public ControladorSolicitacao() {
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
	
	public String adicionarSolicitacao(){
		Tramite tramite = new Tramite();
		tramite.setDepartamento(departamento);		
		tramite.setDataEntrada(new Date());
		tramite.setAtendente(solicitacao.getAtendente());
		solicitacao.getTramites().add(tramite);
		solicitacao.setSituacao(SituacaoSolicitacao.PENDENTE);
		solicitacaoDao.adicionar(solicitacao);
		tramite.setSolicitacao(solicitacao);
		tramiteDao.adicionar(tramite);
		return "solicitacao-list";
	}

}