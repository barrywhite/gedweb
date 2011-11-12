package br.com.modeloArquitetura.modelo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TA_DENTISTA")
@SequenceGenerator(name = "DentistaSeq", sequenceName = "dentista_seq")
public class Dentista {

	@Id
	@Column(name = "ID_DENTISTA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DentistaSeq")
	private Integer id;

	@Column(name = "NO_DENTISTA", length = 100, nullable = false)
	private String nome;

	@Column(name = "CRO_DENTISTA", length = 5)
	private String cro;

	@Column(name = "TITULO_DENTISTA", length = 100)
	private String titulo;

	public Dentista() {
		super();
	}

	public Dentista(Integer id, String nome, String cro, String titulo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cro = cro;
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
