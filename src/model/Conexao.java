package model;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
	}

	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
//	        System.out.println("Conectou papai");
	        return conexao;
			
		} catch (SQLException ex) {
//			System.out.println("Deu ruim aqui em");
			ex.printStackTrace();
		}
		return null;
	}

}
