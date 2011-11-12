package br.com.modeloArquitetura.enuns;


/**
 * Enumera��o que especifica o tipo de opera��o que se est� realizando
 * 
 * @author Barry White
 * @since Outubro 01, 2011
 * 
 */

public enum EnumOperacao {
	
//	BUSCAR, SALVAR
	
	BUSCAR("buscar"),
	SALVAR("salvar");
	
	private String tipo;
	
	
	private EnumOperacao(String t) {
		tipo = t;
	}


	public String getTipo() {
		return tipo;
	}
		

}

