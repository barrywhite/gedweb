package br.com.gedweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.gedweb.modelo.Pessoa;

public class PessoaDao extends CrudGenerico<Pessoa, Integer> {

	public PessoaDao() {
		super(Pessoa.class);
		this.entityManager = new HibernateUtil().getEm();
	}

	@SuppressWarnings("unchecked")
	public Pessoa buscarLogin(List<String> paramName, List<String> param) {
		if (paramName.isEmpty())
			return null;
		Query q = entityManager.createNamedQuery("Pessoa.findLogin");
		for (int i = 0; i < param.size(); i++) {
			q.setParameter(paramName.get(i), param.get(i));
		}
		List<Pessoa> pessoas = q.getResultList();
		return  pessoas.isEmpty() ? null : pessoas.get(0);
	}
}
