package br.com.gedweb.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoTelefoneEnum {
	
	RESIDENCIAL("Residencial"),
	COMERCIAL("Comercial"),
	CELULAR("Celular");
    
    private String nome;
    
    private TipoTelefoneEnum(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public static Object[] valores() {
    	List<String> valores = new ArrayList<String>();
    	for (TipoTelefoneEnum e: values()) {
    		valores.add(e.getNome());
    	}
    	return valores.toArray();
    }

}
