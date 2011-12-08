package br.com.gedweb.controlador.modal;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gedweb.crud.CrudGenerico;
import br.com.gedweb.modelo.Pessoa;

@ManagedBean(name = "controladorModalPessoa")
@SessionScoped
public class ControladorModalPessoa {

	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	public ControladorModalPessoa() {
	
	}
	
	@SuppressWarnings("unchecked")
	public void iniciar() {
		@SuppressWarnings("rawtypes")
		CrudGenerico crud =  new CrudGenerico(Pessoa.class, this.em);
		this.pessoas = crud.buscarTodos();
	}	
	
	public List<Pessoa> getPessoas() {
		iniciar();
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

}
