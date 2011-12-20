package br.com.gedweb.enuns;

public enum SituacaoSolicitacao {

	PENDENTE("PENDENTE"), ATENDIDO("ATENDIDO"), NEGADO("NEGADO");

	private String nome;

	private SituacaoSolicitacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
