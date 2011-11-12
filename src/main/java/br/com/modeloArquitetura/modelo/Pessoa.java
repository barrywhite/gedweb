package br.com.modeloArquitetura.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.modeloArquitetura.enuns.EnumEstadoCivil;
import br.com.modeloArquitetura.enuns.EnumSexo;
import br.com.modeloArquitetura.enuns.EnumTipoPessoa;

@Entity
@Table(name = "TA_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Integer id;
	
	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "ENDERECO", length = 100)
	private String endereco;
	
	@Column(name = "NUMERO", length = 5)
	private int numero;

	@Column(name = "COMPLEMENTO", length = 50)
	private String complemento;
	
	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	@Column(name = "CEP", length = 8)
	private String cep;
	
	@Column(name = "CIDADE", length = 100)
	private String cidade;

	@Column(name = "UF", length = 2)
	private String uf;
	
	@Column(name = "CPF", length = 14)
	private String cpf;
	
	@Column(name = "RG", length = 7)
	private int rg;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCIMENTO", length = 8)
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	private EnumSexo sexo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_CIVIL")
	private EnumEstadoCivil estadoCivil;
	
	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "TELEFONE", length = 14)
	private String telefone;
	
	@Column(name = "CELULAR", length = 14)
	private String celular;
	
	@Column(name = "LOGIN", length = 20)
	private String login;
	
	@Column(name = "SENHA", length = 20)
	private String senha;
	
	@Column(name = "TIPO_PESSOA", length = 20)
	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoPessoa;
		
	@OneToMany
	@JoinColumn(name = "ID_SOLICITACAO")
	private List<Solicitacao> solicitacoes;

	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, String endereco, int numero,
			String complemento, String bairro, String cep, String cidade,
			String uf, String cpf, int rg, Date dataNascimento, EnumSexo sexo,
			EnumEstadoCivil estadoCivil, String email, String telefone,
			String celular, String login, String senha,
			List<Solicitacao> solicitacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.login = login;
		this.senha = senha;
		this.solicitacoes = solicitacoes;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
