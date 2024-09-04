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

		String sql = "SELECT * FROM tb_tarefa";

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
	
	public TarefaBeans buscarPorId(Long id) {

		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		TarefaBeans tarefa = null;

		String sql = "SELECT * FROM tb_tarefa WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setLong(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String descricao = rs.getString("descricao");	
					String status = rs.getString("status");
					
					tarefa = new TarefaBeans();
					tarefa.setId(id);
					tarefa.setDescricao(descricao);
					tarefa.setStatus(status);
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return tarefa;
		}
		return tarefa;
		

	}
	
	public void inserirTarefa(TarefaBeans tarefa) throws SQLException {
		
		Conexao conexao = new Conexao();
		con = conexao.getConexao();
		
		String sql = "INSERT INTO tb_tarefa (descricao, status, dt_criacao) values ( ? , ?, ? )";
		
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
	  
	  String sql = "DELETE FROM tb_tarefa WHERE id = ?";
	  
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
		  
		  String sql = "DELETE FROM tb_tarefa";
		  
		  try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			 pstmt.executeUpdate();
		  }  catch (SQLException e) {
			  e.printStackTrace();
		  }  finally {
			  con.close();
		  }
			
			
		}
	
		public void atualizarTarefa(Long id, String descricao, String status) throws SQLException {
			Conexao conexao = new Conexao();

			con = conexao.getConexao();

			String sql = "UPDATE tb_tarefa set descricao = ?, status = ? WHERE id = ?";

			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, descricao);
				pstmt.setString(2, status);
				pstmt.setLong(3, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.close();
			}

		}
}
