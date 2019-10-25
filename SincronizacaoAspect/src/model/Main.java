package model;
import java.util.Date;

import DAO.LoginDAO;
import DAO.PessoaDAO;
import util.exception.ErroSistema;

public class Main {

	public static void main(String[] args) {
      
		autenticacao();
		salvar();
		
	}
	
	public static void autenticacao() {
		Login login = new Login();
		login.setLogin("root");
		login.setSenha("senha");
		
		try {
			 login.autenticar(login);
		} catch (ErroSistema e) {
			e.printStackTrace();
		}
	}
	
	public static void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setLogin("vaguetti");
		pessoa.setSenha("b");
		pessoa.setDataNascimento(new Date());
		pessoa.setNomeCompleto("leandro vAGUETTI");
		
		try {
			pessoa.salvar(pessoa);
		} catch (ErroSistema e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
