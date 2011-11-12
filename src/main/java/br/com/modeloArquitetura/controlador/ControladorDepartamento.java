package br.com.modeloArquitetura.controlador;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.modelo.Departamento;

@ManagedBean(name = "controladorDepartamento")
@SessionScoped
public class ControladorDepartamento {

	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	EntityManager entityManager = (EntityManager) FacesContext.getCurrentInstance().getApplication().getELResolver().
		getValue(elContext, null, "entityManager");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	private Departamento departamento;	
	private DataModel<Departamento> listaDepartamentos;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adicionar() {
		CrudGenerico crud = new CrudGenerico(Departamento.class, this.em);
		crud.adicionar(departamento);
		return "departamento-list";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String alterar() {
		CrudGenerico crud = new CrudGenerico(Departamento.class, this.em);
		crud.alterar(departamento);
		return "departamento-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excluir() {
		CrudGenerico crud = new CrudGenerico(Departamento.class, this.em);
		crud.excluir(listaDepartamentos.getRowData());
		return "departamento-list";
	}
	
	public String prepararAdicionar() {
		departamento = new Departamento();
		return "departamento";
	}

	public String prepararAlterar() {
		departamento = listaDepartamentos.getRowData();
		return "departamento";
	}
	
	public String prepararExcluir() {
		departamento = listaDepartamentos.getRowData();
		return "departamento";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae) {
		CrudGenerico crud = new CrudGenerico(Departamento.class, this.em);
		crud.buscarPorFiltro(this.departamento);

		this.departamento = new Departamento();
	}

	public DataModel<Departamento> buscarTodos() {
		return getListarDepartamentos();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel<Departamento> getListarDepartamentos() {
		CrudGenerico crud = new CrudGenerico(Departamento.class, this.em);
		listaDepartamentos = new ListDataModel<Departamento>(crud.buscarTodos());
		return listaDepartamentos;
	}

	public void salvar() {

	}

}