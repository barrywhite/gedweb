package br.com.modeloArquitetura.crud;

/*
 * Create - Adicionar nova entidade no banco de dados

 * Read(Retrieve) - Buscar entidades existentes no banco de dados
 * Update - Alterar entidades existentes no banco de dados
 * Delete - Excluir entidades existentes no banco de dados
 */

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.modeloArquitetura.interfaces.ICrudGenerico;

public class CrudGenerico<T, PK extends Serializable> implements ICrudGenerico<T, PK> {

	private final Class<T> classePersistente;

	private EntityManager entityManager;

	public CrudGenerico(final Class<T> classePersistente, EntityManager entityManager) {
		this.classePersistente = classePersistente;
		this.entityManager = entityManager;

	}

	@Override
	public Class<T> getClassePersistente() {
		return classePersistente;
	}

	@Override
	public Boolean adicionar(final T objeto) {
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(objeto);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();

		return true;
	}

	@Override
	public T buscarPorChave(PK primaryKey) {
		return this.entityManager.find(this.classePersistente, primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarPorFiltro(T filtro) {
		return (List<T>) this.entityManager.find(this.classePersistente, filtro);// nao funcionando
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> buscarTodos() {
		/**
		 * Utilizando a linguagem de consulta JPQL do JPA, cuja vantagem em relação a SQL, é que a sintaxe é a mesma para banco de dados diferentes.
		 * 
		 * @author Barry White
		 * @since Outubro 02, 2011
		 * @return uma lista de qualquer classe persistente
		 * 
		 */
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		Query query = this.entityManager.createQuery(cq.select(cq.from(this.classePersistente)));
		List<T> lista = query.getResultList();

		return lista;
	}

	@Override
	public Boolean alterar(T objeto) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(objeto);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public Boolean excluir(T objeto) {
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(objeto);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public T get(PK primaryKey) {
		return null;
	}

}
