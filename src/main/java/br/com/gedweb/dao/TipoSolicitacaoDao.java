package br.com.gedweb.dao;

import br.com.gedweb.modelo.TipoSolicitacao;

public class TipoSolicitacaoDao extends CrudGenerico<TipoSolicitacao, Integer>{
	
	public TipoSolicitacaoDao(){
		super(TipoSolicitacao.class);
		this.entityManager = new HibernateUtil().getEm();
	}
}
