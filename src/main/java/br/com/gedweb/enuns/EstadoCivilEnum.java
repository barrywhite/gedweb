package br.com.gedweb.enuns;

public enum EstadoCivilEnum {

	SOLTEIRO("Solteiro"), 
	CASADO("Casado"), 
	DIVORCIADO("Divorciado"), 
	VIUVO("Vi�vo"), 
	OUTROS("Outros");

	private String tipo;

	private EstadoCivilEnum(String t) {
		tipo = t;
	}

	public String getTipo() {
		return tipo;
	}

}
