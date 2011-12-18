package br.com.gedweb.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gedweb.dao.PessoaDao;
import br.com.gedweb.modelo.Pessoa;

@ManagedBean(name = "controladorLogin")
@SessionScoped
public class ControladorLogin {

	private PessoaDao pessoaDao;
	private Pessoa pessoa;

	public ControladorLogin() {
		pessoa = new Pessoa();
		pessoaDao = new PessoaDao();
	}

	public String Logar() {

		List<String> paramName = new ArrayList<String>();
		List<String> param = new ArrayList<String>();
		paramName.add("login");
		param.add(pessoa.getLogin().toUpperCase());
		paramName.add("senha");
		param.add(pessoa.getSenha().toUpperCase());
		if (pessoaDao.buscarLogin(paramName, param) != null) {
			return "cadastros/aluno-list";
		}
		return "";
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

}
