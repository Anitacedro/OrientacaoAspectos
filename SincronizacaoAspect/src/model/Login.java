package model;

import util.exception.ErroSistema;

public class Login {
	
	private String login;
	private String senha;
	private String status;
	
	public Login(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public Login() {
		super();
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
	
	public void autenticar(Login l) throws ErroSistema {
		 	System.out.println("Usuário com status: "+l.getStatus());
 
	 }
	

}
