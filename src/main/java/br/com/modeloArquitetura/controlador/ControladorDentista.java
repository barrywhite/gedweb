package br.com.modeloArquitetura.controlador;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;

//import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.enuns.EnumOperacao;
import br.com.modeloArquitetura.modelo.Dentista;

@ManagedBean(name = "controladorDentista")
public class ControladorDentista {

//	@ManagedProperty(value = "#{entityManager}")//entity manager em escopo de requisição
//	private EntityManager entityManager;
	
	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	EntityManager entityManager = (EntityManager)FacesContext.getCurrentInstance().
		getApplication().getELResolver().getValue(elContext, null, "entityManager");
	
	
	private EnumOperacao operacao = EnumOperacao.BUSCAR;
	
	private Boolean mostrarTabelaResultado = false;

	private Dentista dentista = new Dentista();
	
	private List<Dentista> listaDentistas;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void adicionar(ActionEvent ae) {		

		CrudGenerico crud = new CrudGenerico(Dentista.class, this.entityManager);
		crud.adicionar(this.dentista);

		this.dentista = new Dentista();
		setOperacao(EnumOperacao.BUSCAR);
			
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae){
		CrudGenerico crud = new CrudGenerico(Dentista.class, this.entityManager);
		crud.buscarPorFiltro(this.dentista);
		
		this.dentista = new Dentista();
//		setOperacao(EnumOperacao.BUSCAR);
	}
	
	public List<Dentista> buscarTodos(){
		
		return getListaDentista();
		
	}
	
	public void setarOperacaoSalvar(ActionEvent ae){
		setOperacao(EnumOperacao.SALVAR);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	

	public EnumOperacao getOperacao() {
		return operacao;
	}

	public void setOperacao(EnumOperacao operacao) {
		this.operacao = operacao;
	}	

	public Boolean getMostrarTabelaResultado() {
		return mostrarTabelaResultado;
	}

	public void setMostrarTabelaResultado(Boolean mostrarTabelaResultado) {
		this.mostrarTabelaResultado = mostrarTabelaResultado;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Dentista> getListaDentista() {
		if(mostrarTabelaResultado.equals(true)){
		CrudGenerico crud = new CrudGenerico(Dentista.class, this.entityManager);
		listaDentistas = crud.buscarTodos();}
		
		return listaDentistas;
	}	

}