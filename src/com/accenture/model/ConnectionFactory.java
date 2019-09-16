package com.accenture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	Connection conexao ;
	
	public Connection getConnection() {
		conexao =null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            conexao= DriverManager.getConnection(
                    "jdbc:mysql://localhost/gestao_faculdade", "root", "bd12345");
        } catch (SQLException e) {
        	System.out.println("Não conectou");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//        finally {
//			conexao.close();
//		}
        
    	return conexao;		
    }
	
	
//	public String retornarNome() throws SQLException {
//		conexao=getConnection();
//		
//		String retorno = null;
//		
//		Statement st = conexao.createStatement();
//		
//		
//		String sql = "select nome_aluno from aluno where cod_matricula=3";
//		
//		ResultSet result = st.executeQuery(sql);
//		
//		
//		if (result.next()) {
//			retorno= result.getString(1); 
//			
//		}
//		return retorno;
//	}
	
	

}
