package br.com.modeloArquitetura.enuns;


/**
 * Enumera��o que especifica o Sexo de uma Pessoa F�sica
 * 
 * @author Barry White
 * @since Setembro 21, 2011
 * 
 */

public enum EnumEstadoCivil {
	
	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Vi�vo"),
	OUTROS("Outros");
	
	private String tipo;
	
	
	private EnumEstadoCivil(String t) {
		tipo = t;
	}


	public String getTipo() {
		return tipo;
	}

}
