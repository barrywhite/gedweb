package br.com.gedweb.dao;

import br.com.gedweb.modelo.Departamento;

public class DepartamentoDao extends CrudGenerico<Departamento, Integer>{
	
	public DepartamentoDao(){
		super(Departamento.class);
		this.entityManager = new HibernateUtil().getEm();
	}
}
