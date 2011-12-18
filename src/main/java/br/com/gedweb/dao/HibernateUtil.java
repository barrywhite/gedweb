package br.com.gedweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	static {
		try {

			emf = Persistence.createEntityManagerFactory("unidadePersistence");
			em = emf.createEntityManager();
		} catch (Exception e) {
			System.out.println("ERRO AO INICIALIZAR ENTITY MANAGER");
			throw new ExceptionInInitializerError(e);
		}
	}

	public EntityManager getEm() {
		return em;
	}

}
