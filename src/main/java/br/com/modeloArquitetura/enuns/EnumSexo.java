package br.com.modeloArquitetura.enuns;


/**
 * Enumeração que especifica o Sexo de uma Pessoa Física
 * 
 * @author Barry White
 * @since Setembro 21, 2011
 * 
 */

public enum EnumSexo {
	
	MASCULINO("M"),
	FEMININO("F");
	
	private String sexo;
	
	
	private EnumSexo(String s) {
		sexo = s;
	}


	public String getTipo() {
		return sexo;
	}


		

}
