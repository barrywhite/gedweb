package br.com.gedweb.filtro;

import java.io.IOException;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * Técnica: Open Session In View
 * 
 * Implementação da interface Filter do Servlet 3.0 para criação
 * da fábrica (factory) do gerenciador de entidades (entity manager),
 * para que uma mesma factory seja usada durante toda a execução da
 * aplicação, evitando assim, o LazyInitializationException do Hibernate
 * 
 * @autor: Joel Marques
 * @see: http://blog.caelum.com.br/enfrentando-a-lazyinitializationexception-no-hibernate/
 * http://community.jboss.org/wiki/OpenSessioninView
 */

//@WebFilter(servletNames = {"filtroEntityManagerOpenSessionInView"})
@WebFilter(servletNames = {"Faces Servlet"})
public class JPAFilter implements Filter {

	protected EntityManagerFactory factory;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		EntityManager entityManager = this.factory.createEntityManager();
		request.setAttribute("entityManager", entityManager);
		entityManager.getTransaction().begin();
		
		chain.doFilter(request, response);
		
		try {
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("unidadePersistence");
	}

	@Override
	public void destroy() {
		this.factory.close();
	}
}
