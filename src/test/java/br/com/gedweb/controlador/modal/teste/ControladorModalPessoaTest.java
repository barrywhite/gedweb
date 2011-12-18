package br.com.gedweb.controlador.modal.teste;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.gedweb.dao.CrudGenerico;
import br.com.gedweb.modelo.Pessoa;

public class ControladorModalPessoaTest {

	@Test
	public void testGetPessoas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
		EntityManager em = emf.createEntityManager();
		CrudGenerico<Pessoa, Integer> crud =  new CrudGenerico<Pessoa, Integer>(Pessoa.class, em);
		assertNotNull(crud.buscarTodos());
	}
}
