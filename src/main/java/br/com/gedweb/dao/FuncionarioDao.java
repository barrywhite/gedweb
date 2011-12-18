package br.com.gedweb.dao;

import br.com.gedweb.modelo.Funcionario;

public class FuncionarioDao extends CrudGenerico<Funcionario, Integer> {

	public FuncionarioDao() {
		super(Funcionario.class);
		this.entityManager = new HibernateUtil().getEm();
	}
}
