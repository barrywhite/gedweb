package br.com.gedweb.controlador;

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

import br.com.gedweb.crud.CrudGenerico;
import br.com.gedweb.enuns.EstadoCivilEnum;
import br.com.gedweb.enuns.SexoEnum;
import br.com.gedweb.modelo.Funcionario;

@ManagedBean(name = "controladorFuncionario")
@SessionScoped
public class ControladorFuncionario {

	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	EntityManager entityManager = (EntityManager) FacesContext.getCurrentInstance().getApplication().getELResolver().
		getValue(elContext, null, "entityManager");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
	EntityManager em = emf.createEntityManager();

	private Funcionario funcionario;	
	private DataModel<Funcionario> listaFuncionarios;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String adicionar() {
		CrudGenerico crud = new CrudGenerico(Funcionario.class, this.em);
		crud.adicionar(funcionario);
		return "funcionario-list";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String alterar() {
		CrudGenerico crud = new CrudGenerico(Funcionario.class, this.em);
		crud.alterar(funcionario);
		return "funcionario-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excluir() {
		CrudGenerico crud = new CrudGenerico(Funcionario.class, this.em);
		crud.excluir(listaFuncionarios.getRowData());
		return "funcionario-list";
	}
	
	public String prepararAdicionar() {
		funcionario = new Funcionario();
		return "funcionario";
	}

	public String prepararAlterar() {
		funcionario = listaFuncionarios.getRowData();
		return "funcionario";
	}
	
	public String prepararExcluir() {
		funcionario = listaFuncionarios.getRowData();
		return "funcionario";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae) {
		CrudGenerico crud = new CrudGenerico(Funcionario.class, this.em);
		crud.buscarPorFiltro(this.funcionario);

		this.funcionario = new Funcionario();
	}

	public DataModel<Funcionario> buscarTodos() {
		return getListarFuncionario();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel<Funcionario> getListarFuncionario() {
		CrudGenerico crud = new CrudGenerico(Funcionario.class, this.em);
		listaFuncionarios = new ListDataModel<Funcionario>(crud.buscarTodos());
		return listaFuncionarios;
	}

	public void salvar() {

	}

	public SelectItem[] getEstadoCivil() {
		SelectItem[] items = new SelectItem[EstadoCivilEnum.values().length];
		int i = 0;
		for(EstadoCivilEnum t: EstadoCivilEnum.values()) {
			items[i++] = new SelectItem(t, t.name());
		}
		return items;
	}
	
	public SelectItem[] getSexo() {
		SelectItem[] items = new SelectItem[SexoEnum.values().length];
		int i = 0;
		for(SexoEnum s: SexoEnum.values()) {
			items[i++] = new SelectItem(s, s.name());
		}
		return items;
	}

}