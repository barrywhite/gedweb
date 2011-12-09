package br.com.gedweb.controlador;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gedweb.crud.CrudGenerico;
import br.com.gedweb.enuns.EstadoCivilEnum;
import br.com.gedweb.enuns.SexoEnum;
import br.com.gedweb.modelo.Aluno;

@ManagedBean(name = "controladorAluno")
@SessionScoped
public class ControladorAluno {

	private ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	private EntityManager entityManager = (EntityManager) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "entityManager");

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	private EntityManager em = emf.createEntityManager();

	private Aluno alunoSelecionado;
	private DataModel<Aluno> listaAlunos;
	private CrudGenerico crud;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adicionar() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.adicionar(alunoSelecionado);
		return "aluno-list";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String alterar() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.alterar(alunoSelecionado);
		return "aluno-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excluir() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.excluir(listaAlunos.getRowData());
		return "aluno-list";
	}

	public String prepararAdicionar() {
		alunoSelecionado = new Aluno();
		return "aluno";
	}

	public String prepararAlterar() {
		alunoSelecionado = listaAlunos.getRowData();
		return "aluno";
	}

	public String prepararExcluir() {
		alunoSelecionado = listaAlunos.getRowData();
		return "aluno";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae) {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.buscarPorFiltro(this.alunoSelecionado);

		this.alunoSelecionado = new Aluno();
	}

	

	public void salvar() {

	}

	public SelectItem[] getEstadoCivil() {
		SelectItem[] items = new SelectItem[EstadoCivilEnum.values().length];
		int i = 0;
		for (EstadoCivilEnum t : EstadoCivilEnum.values()) {
			items[i++] = new SelectItem(t, t.name());
		}
		return items;
	}

	public SelectItem[] getSexo() {
		SelectItem[] items = new SelectItem[SexoEnum.values().length];
		int i = 0;
		for (SexoEnum s : SexoEnum.values()) {
			items[i++] = new SelectItem(s, s.name());
		}
		return items;
	}

	public void setAlunos(List<Aluno> alunos) {
	
	}

	public List<Aluno> getAlunos() {
		crud = new CrudGenerico(Aluno.class, this.em);
		return crud.buscarTodos() ;
	}

	public void setAlunoSelecionado(Aluno aluno) {
		this.alunoSelecionado = aluno;
	}

	public Aluno getAlunoSelecionado() {
		return this.alunoSelecionado;
	}

}