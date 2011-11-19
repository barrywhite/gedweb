package br.com.modeloArquitetura.controlador;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.enuns.EnumEstadoCivil;
import br.com.modeloArquitetura.enuns.EnumSexo;
import br.com.modeloArquitetura.modelo.Aluno;

@ManagedBean(name = "controladorAluno")
@SessionScoped
public class ControladorAluno {
	

	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	EntityManager entityManager = (EntityManager) FacesContext.getCurrentInstance().getApplication().getELResolver().
		getValue(elContext, null, "entityManager");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	private Aluno aluno;	
	private DataModel<Aluno> listaAlunos;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adicionar() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.adicionar(aluno);
		return "aluno-list";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String alterar() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.alterar(aluno);
		return "aluno-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excluir() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.excluir(listaAlunos.getRowData());
		return "aluno-list";
	}
	
	public String prepararAdicionar() {
		aluno = new Aluno();
		return "aluno";
	}

	public String prepararAlterar() {
		aluno = listaAlunos.getRowData();
		return "aluno";
	}
	
	public String prepararExcluir() {
		aluno = listaAlunos.getRowData();
		return "aluno";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae) {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		crud.buscarPorFiltro(this.aluno);

		this.aluno = new Aluno();
	}

	public DataModel<Aluno> buscarTodos() {
		return getListarAlunos();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel<Aluno> getListarAlunos() {
		CrudGenerico crud = new CrudGenerico(Aluno.class, this.em);
		listaAlunos = new ListDataModel<Aluno>(crud.buscarTodos());
		return listaAlunos;
	}

	public void salvar() {

	}

	public SelectItem[] getEstadoCivil() {
		SelectItem[] items = new SelectItem[EnumEstadoCivil.values().length];
		int i = 0;
		for(EnumEstadoCivil t: EnumEstadoCivil.values()) {
			items[i++] = new SelectItem(t, t.name());
		}
		return items;
	}
	
	public SelectItem[] getSexo() {
		SelectItem[] items = new SelectItem[EnumSexo.values().length];
		int i = 0;
		for(EnumSexo s: EnumSexo.values()) {
			items[i++] = new SelectItem(s, s.name());
		}
		return items;
	}

}