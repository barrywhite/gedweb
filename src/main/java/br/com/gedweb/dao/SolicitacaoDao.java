package br.com.gedweb.dao;

import br.com.gedweb.modelo.Solicitacao;


public class SolicitacaoDao extends CrudGenerico<Solicitacao, Integer> {

	
	public SolicitacaoDao() {
		super(Solicitacao.class);
		this.entityManager = new HibernateUtil().getEm();
	}
	
	
	
}

