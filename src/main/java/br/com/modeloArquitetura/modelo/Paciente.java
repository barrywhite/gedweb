package br.com.modeloArquitetura.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TA_PACIENTE")
@SequenceGenerator(name = "PacienteSeq", sequenceName = "paciente_seq")
public class Paciente {
	
	@Id
	@Column(name = "ID_PACIENTE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PacienteSeq")
	private Integer id;
	
	@Column(name = "NOME_PACIENTE")
	private String nome;
	
	@Column(name = "NOME_RESPONSAVEL")
	private String nomeResponsavel;
	
	@Column(name = "CPF_RESPONSAVEL")
	private String cpfResponsavel;
	
	@Column(name = "RG_RESPONSAVEL")
	private String rgResponsavel;
	
	@Column(name = "TELEFONE_RESPONSAVEL")
	private String telefoneResponsavel;
	
	@Column(name = "CELULAR_RESPONSAVEL")
	private String celularResponsavel;

	public Paciente() {
		super();
	}

	

	public Paciente(Integer id, String nome, String nomeResponsavel,
			String cpfResponsavel, String rgResponsavel,
			String telefoneResponsavel, String celularResponsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeResponsavel = nomeResponsavel;
		this.cpfResponsavel = cpfResponsavel;
		this.rgResponsavel = rgResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;
		this.celularResponsavel = celularResponsavel;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}

	public String getCelularResponsavel() {
		return celularResponsavel;
	}

	public void setCelularResponsavel(String celularResponsavel) {
		this.celularResponsavel = celularResponsavel;
	}
	
	

}
