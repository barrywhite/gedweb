package br.com.gedweb.interfaces;

import java.io.Serializable;

import java.util.List;

public interface ICrudGenerico<T, PK extends Serializable> {

	public Class<T> getClassePersistente();

	public Boolean adicionar(T objeto);

	public T buscarPorChave(PK primaryKey);

	public List<T> buscarTodos();

	public Boolean alterar(T objeto);

	public Boolean excluir(T objeto);

}
