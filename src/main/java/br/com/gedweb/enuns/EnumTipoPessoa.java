package br.com.gedweb.enuns;

public enum EnumTipoPessoa {

	ALUNO("ALUNO"), FUNCIONARIO("FUNCIONARIO");
	
	private String tipo;

	private EnumTipoPessoa(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
