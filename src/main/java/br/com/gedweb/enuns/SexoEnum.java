package br.com.gedweb.enuns;

/**
 * Enumera��o que especifica o Sexo de uma Pessoa F�sica
 * 
 * @author Barry White
 * @since Setembro 21, 2011
 * 
 */

public enum SexoEnum {

	MASCULINO("M"), FEMININO("F");

	private String sexo;

	private SexoEnum(String s) {
		sexo = s;
	}

	public String getTipo() {
		return sexo;
	}

}
