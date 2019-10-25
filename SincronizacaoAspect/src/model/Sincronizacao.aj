package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.exception.ErroSistema;
import model.Login;
import model.Pessoa;

public aspect Sincronizacao { 

      pointcut greetingAutentica() : execution(* Login.autenticar(..));
      pointcut greetingSalva() : execution(* Pessoa.salvar(..));

     
     before(Login l) : greetingAutentica() && target(l) { 

    	 String sql = "select login,senha from login as a where a.login = ? and senha = ?";
	        try {
	            Connection conexao = ConnectionFactory.getConexao();
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setString(1, l.getLogin());
	            ps.setString(2, l.getSenha());
	            l.setStatus("AUTENTICADO");
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	    	        ConnectionFactory.fechaConexao();
	            }else {
	    	        ConnectionFactory.fechaConexao();
	            }
	        } catch (ErroSistema ex) {
	           // throw new ErroSistema("Erro ao tentar se logar!", ex);
	        } catch (SQLException ex) {
	           // throw new ErroSistema("Erro ao tentar se logar!", ex);
	        }
	         System.out.print("Verificando autenticacao de usuario\n"); 

	    }
      
     
     before(Pessoa f) : greetingSalva() && target(f) { 
         System.out.print("Verificando cadastro de usuario\n"); 
         
         String sql = "INSERT INTO pessoa (nomeCompleto,dataNascimento,login, senha)VALUES(?,?,?,?);";
	        try {
	            Connection conexao = ConnectionFactory.getConexao();
	            CallableStatement cs = conexao.prepareCall(sql);
	            cs.setString(1, f.getNomeCompleto());
	            cs.setDate(2, new Date(f.getDataNascimento().getTime()));
	            cs.setString(3, f.getLogin());
	            cs.setString(4, f.getSenha());
	            f.setStatus("SUCESSO");

	            cs.execute();
	            ConnectionFactory.fechaConexao();
	        } catch (ErroSistema ex) {
	            try {
					throw new ErroSistema("Erro ao cadastrar funcionário!", ex);
				} catch (ErroSistema e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (SQLException ex) {
	            try {
					throw new ErroSistema("Erro ao cadastrar funcionário!", ex);
				} catch (ErroSistema e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
     } 
     

 }