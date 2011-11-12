package br.com.modeloArquitetura.enuns;


/**
 * Enumeração que especifica o Sexo de uma Pessoa Física
 * 
 * @author Barry White
 * @since Setembro 21, 2011
 * 
 */

public enum EnumEstadoCivil {
	
	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo"),
	OUTROS("Outros");
	
	private String tipo;
	
	
	private EnumEstadoCivil(String t) {
		tipo = t;
	}


	public String getTipo() {
		return tipo;
	}

}
