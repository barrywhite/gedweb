package br.com.modeloArquitetura;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modeloArquitetura.crud.CrudGenerico;
import br.com.modeloArquitetura.modelo.Dentista;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// PRIMEIRO MODO (usando o arquivo persistence.xml)
//
//		Dentista dentista = new Dentista();
//		dentista.setNome("Joel Siqueira Marques");
//		dentista.setTitulo("Mestre");
//		dentista.setCro("123");
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");// mesmo nome de persistence-unit
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//		// em.persist(dentista);
//
//		// teste do Crud Generico. o metodo adicionar est� ok!!!
//		@SuppressWarnings("rawtypes")
//		CrudGenerico crud = new CrudGenerico(Dentista.class, em);
//		crud.adicionar(dentista);
//
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println("Novo dentista salvo com sucesso! :"+dentista.getNome());
		
		

		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");// mesmo nome de persistence-unit
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//		// em.persist(dentista);
//
//		// teste do Crud Generico. o metodo buscarPorChave est� ok!!!
//		@SuppressWarnings("rawtypes")
//		CrudGenerico crud = new CrudGenerico(Dentista.class, em);
//		Dentista dentista = new Dentista();
//		dentista = (Dentista)crud.buscarPorChave(9);//a chave pode ser de qualquer tipo
//
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println("Dentista encontrado com sucesso! :"+dentista.getNome());
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");// mesmo nome de persistence-unit
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//		// em.persist(dentista);
//
//		// teste do Crud Generico. o metodo buscarTodos est� ok!!!
//		@SuppressWarnings("rawtypes")
//		CrudGenerico crud = new CrudGenerico(Dentista.class, em);
//		
//		List<Dentista> listaDentista = new ArrayList<Dentista>();
//		listaDentista = crud.buscarTodos();
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		for(Dentista d : listaDentista){
//		
//		System.out.println("Dentista: " +d.getNome());
//		}
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");// mesmo nome de persistence-unit
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//		// em.persist(dentista);
//
//		// teste do Crud Generico. o metodo alterar est� ok!!!
//		@SuppressWarnings("rawtypes")
//		CrudGenerico crud = new CrudGenerico(Dentista.class, em);
//		
//		Dentista dentista = (Dentista)crud.buscarPorChave(10);
//		
//		System.out.println("Nome antigo: " +dentista.getNome());
//		
//		dentista.setNome("nome alterado");
//		
//		crud.alterar(dentista);
//		
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		System.out.println("Novo nome: " +dentista.getNome()+", id : "+dentista.getId());
		
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadePersistence");// mesmo nome de persistence-unit
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		// em.persist(dentista);

		// teste do Crud Generico. o metodo excluir est� ok!!!
		@SuppressWarnings("rawtypes")
		CrudGenerico crud = new CrudGenerico(Dentista.class, em);
		
		Dentista dentista = (Dentista)crud.buscarPorChave(11);
		
		crud.excluir(dentista);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println("Excluido com sucesso!" + " id : "+dentista.getId());

		


	}

}