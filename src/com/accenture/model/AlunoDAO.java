package com.accenture.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
	
	private Connection connection;

	public AlunoDAO(){
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void cadastrarAluno(Aluno aluno) {
		String insertSql =  "insert into aluno (nome_aluno, email, curso)"
				+ "values(?,?,?)";
		
		
		 try {
	            // prepared statement para inserção
	            PreparedStatement stmt = connection.prepareStatement(insertSql);

	            // seta os valores

	            stmt.setString(1,aluno.getNome());
	            stmt.setString(2,aluno.getEmail());
	            stmt.setString(3,aluno.getCurso());
	           

	            // executa
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
	public int getCodMtriculaNovoCadastro() {
		String sql = "select max(cod_matricula) from aluno";
		String codmatricula=null;
		int codigo=0;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				codmatricula=rs.getString(1);
				 codigo = Integer.parseInt(codmatricula);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return codigo;
	}
	
	
	public List<Avaliacao> getConsulta(int codmatricula) {
		
		String consultaSql = "select * from avaliacao where cod_matricula=?";
		List<Avaliacao> retornconsulta = new ArrayList<Avaliacao>();
	
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement(consultaSql);
			st.setInt(1,codmatricula);
			st.execute();
			
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				Avaliacao a = new Avaliacao();
				a.setCodMatricula(rs.getInt("cod_matricula"));
				a.setNota1(rs.getString("nota1"));
				a.setNota2(rs.getString("nota2"));
				a.setNota3(rs.getString("nota3"));
				a.setMediaponderada(rs.getDouble("media_ponderada"));
				a.setNotafinal(rs.getDouble("nota_final"));
				
				retornconsulta.add(a);
			}
			rs.close();
			st.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retornconsulta;
	
	}
	
	
	public void atualizarAluno(String dado, int codmatricula, Aluno aluno) {
		String sql = null;
		
		PreparedStatement st = null;
		
		
		try {
	
			if(dado.equals("email")) {
				sql = "update aluno set email =? where cod_matricula=?";
				st = connection.prepareStatement(sql);
				st.setString(1, aluno.getEmail());
				st.setInt(2, codmatricula);
			}
			else if (dado.equals("nome")) {
				sql = "update aluno set nome_aluno =? where cod_matricula=?";
				st = connection.prepareStatement(sql);
				st.setString(1, aluno.getNome());
				st.setInt(2, codmatricula);
			}
			else if (dado.equals("curso")) {
				sql = "update aluno set curso =? where cod_matricula=?";
				st = connection.prepareStatement(sql);
				st.setString(1, aluno.getCurso());
				st.setInt(2, codmatricula);
		
			}
			
			else if(dado.equals("todos")) {
				sql = "update aluno set nome_aluno =?,  email =?, curso =? where cod_matricula=?";
				st = connection.prepareStatement(sql);
				st.setString(1, aluno.getNome());
				st.setString(2, aluno.getEmail());
				st.setString(3, aluno.getCurso());
				st.setInt(4, codmatricula);
			}
			
			
			st.execute();
			st.close();
			

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
	
		
	}
	

	
	

}
