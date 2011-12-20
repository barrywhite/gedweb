package br.com.gedweb.enuns;

/**
 * Enumeração que especifica o Sexo de uma Pessoa Física
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
