package br.com.gedweb.dao;

import br.com.gedweb.modelo.Tramite;

public class TramiteDao extends CrudGenerico<Tramite, Integer>{
	
	public TramiteDao(){
		super(Tramite.class);
		this.entityManager = new HibernateUtil().getEm();
	}
}
