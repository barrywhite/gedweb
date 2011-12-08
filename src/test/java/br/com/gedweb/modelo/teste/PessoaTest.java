package br.com.gedweb.modelo.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.gedweb.crud.CrudGenerico;
import br.com.gedweb.modelo.Pessoa;


public class PessoaTest {

	@Test
	public void cadAluno(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");
		EntityManager em = emf.createEntityManager();
		CrudGenerico crud =  new CrudGenerico(Pessoa.class, em);
		crud.adicionar(new Pessoa("Teste Pessoa"));
	}
	
	
}
