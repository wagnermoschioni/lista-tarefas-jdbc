package apptarefa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apptarefa.model.TarefaBeans;

public class TarefaDAO {

	private Connection con = null;

	public List<TarefaBeans> listaTarefas() {

		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		List<TarefaBeans> tarefas = new ArrayList<TarefaBeans>();

		String sql = "SELECT * FROM Tarefa";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				TarefaBeans tarefa = new TarefaBeans();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(rs.getString("status"));

				tarefas.add(tarefa);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return tarefas;

	}
	
	public void inserirTarefa(TarefaBeans tarefa) throws SQLException {
		
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		
		String sql = "INSERT INTO Tarefa (descricao, status, dt_criacao) values ( ? , ?, ? )";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, tarefa.getDescricao());
			pstmt.setString(2, tarefa.getStatus());
			
			java.sql.Date dataParam = new java.sql.Date(tarefa.getDataAbertura().getTime());
			pstmt.setDate(3, dataParam);
			
			System.out.println(tarefa.getDataAbertura());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();
		}	
		
		
	}
	
	public void excluirTarefa(Long id) throws SQLException {
		  
	  Conexao conexao = new Conexao();
	  
	  con =  conexao.getConexao();
	  
	  String sql = "DELETE FROM tarefa WHERE id = ?";
	  
	  try (PreparedStatement pstmt = con.prepareStatement(sql)) {
		  pstmt.setLong(1, id);
		  pstmt.executeUpdate();
	  }  catch (SQLException e) {
		  e.printStackTrace();
	  }  finally {
		  con.close();
	  }
		
		
	}
	
	
	public void excluirTudo() throws SQLException {
		  
		  Conexao conexao = new Conexao();
		  
		  con =  conexao.getConexao();
		  
		  String sql = "DELETE FROM tarefa";
		  
		  try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			 // pstmt.setLong(1, id);
			  pstmt.executeUpdate();
		  }  catch (SQLException e) {
			  e.printStackTrace();
		  }  finally {
			  con.close();
		  }
			
			
		}

}
