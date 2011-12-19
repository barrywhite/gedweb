package br.com.gedweb.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;

import br.com.gedweb.enuns.EstadoCivilEnum;
import br.com.gedweb.enuns.SexoEnum;
import br.com.gedweb.modelo.Aluno;

@ManagedBean(name = "controladorAluno")
@SessionScoped
public class ControladorAluno {

	private Aluno alunoSelecionado;
	private DataModel<Aluno> listaAlunos;

	public String adicionar() {
		return "aluno-list";
	}

	public String alterar() {
		return "aluno-list";
	}

	public String excluir() {
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

	public void buscarPorFiltro(ActionEvent ae) {

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
		return null;
	}

	public void setAlunoSelecionado(Aluno aluno) {
		this.alunoSelecionado = aluno;
	}

	public Aluno getAlunoSelecionado() {
		return this.alunoSelecionado;
	}

}