package model;
import java.util.Date;

import util.exception.ErroSistema;

public class Pessoa {
	
	private String nomeCompleto;
	private Date dataNascimento;
	private String login;
	private String senha;
	private String status;
	

	public Pessoa(String nomeCompleto, Date dataNascimento, String login, String senha) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}
	
	
	public Pessoa() {
		super();
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	 public void salvar(Pessoa f) throws ErroSistema {
		 	System.out.println("salvando o objeto com status: "+f.getStatus());
	    }
	

}
