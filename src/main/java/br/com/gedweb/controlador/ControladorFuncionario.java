package br.com.gedweb.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.gedweb.dao.FuncionarioDao;
import br.com.gedweb.enuns.EstadoCivilEnum;
import br.com.gedweb.enuns.SexoEnum;
import br.com.gedweb.modelo.Funcionario;

@ManagedBean(name = "controladorFuncionario")
@SessionScoped
public class ControladorFuncionario {

	private Funcionario funcionarioSelecionado;
	private FuncionarioDao funcionarioDao;

	public ControladorFuncionario() {
		funcionarioDao = new FuncionarioDao();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarioDao.buscarTodos();
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

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

}