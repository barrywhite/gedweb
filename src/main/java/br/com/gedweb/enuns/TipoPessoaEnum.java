package br.com.gedweb.enuns;

public enum TipoPessoaEnum {

	ALUNO("ALUNO"),
	FUNCIONARIO("FUNCIONARIO");
	
	private String tipo;

	private TipoPessoaEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
