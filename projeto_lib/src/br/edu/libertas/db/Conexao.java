package br.edu.libertas.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private Connection conexao;
	
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param
	 * @description Responsavel por realizar a conexão com banco de dados
	*/
	public Conexao() {
		
		try {
			String url = "jdbc:mariadb://localhost:3306/projeto_lib";
			conexao = DriverManager.getConnection(url, "root", "123456");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
}
