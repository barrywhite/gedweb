package br.com.modeloArquitetura.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.enuns.EnumOperacao;
import br.com.modeloArquitetura.modelo.Dentista;
import br.com.modeloArquitetura.modelo.Paciente;

@ManagedBean(name = "controladorPaciente")
public class ControladorPaciente {
	
	@ManagedProperty(value = "#{entityManager}")//entity manager em escopo de requisição
	private EntityManager entityManager;
	
	private EnumOperacao operacao = EnumOperacao.BUSCAR;
	
	private Boolean mostrarTabelaResultado = false;
	
	private Paciente paciente = new Paciente();
	
	List<Paciente> listaPacientes;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void adicionar(ActionEvent ae) {		

		CrudGenerico crud = new CrudGenerico(Dentista.class, this.entityManager);
		crud.adicionar(this.paciente);

		this.paciente = new Paciente();
		setOperacao(EnumOperacao.BUSCAR);
			
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarPorFiltro(ActionEvent ae){
		CrudGenerico crud = new CrudGenerico(Paciente.class, this.entityManager);
		crud.buscarPorFiltro(this.paciente);
		
		this.paciente = new Paciente();
	}
	
	public List<Paciente> buscarTodos(){
		
		return getListaPaciente();
		
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Paciente> getListaPaciente() {
		if(mostrarTabelaResultado.equals(true)){
		CrudGenerico crud = new CrudGenerico(Paciente.class, this.entityManager);
		listaPacientes = crud.buscarTodos();}
		
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	


}
