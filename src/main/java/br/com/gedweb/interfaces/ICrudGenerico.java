package br.com.gedweb.interfaces;

import java.io.Serializable;

import java.util.List;

//http://community.jboss.org/wiki/GenericDataAccessObjects
//http://www.urubatan.com.br/dao-generico-um-exemplo-a-pedidos/

public interface ICrudGenerico<T, PK extends Serializable> {

	public Class<T> getClassePersistente();

	public Boolean adicionar(T objeto);

	public T buscarPorChave(PK primaryKey);

	public List<T> buscarPorFiltro(final T filtro);

	public List<T> buscarTodos();

	public Boolean alterar(T objeto);

	public Boolean excluir(T objeto);

	public T get(PK primaryKey);

}
