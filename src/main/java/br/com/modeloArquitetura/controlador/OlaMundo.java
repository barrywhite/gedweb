package br.com.modeloArquitetura.controlador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class OlaMundo implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	private String name;
	private String teste;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeste() {
		return teste;
	}
	public void setTeste(String teste) {
		this.teste = teste;
	}
}