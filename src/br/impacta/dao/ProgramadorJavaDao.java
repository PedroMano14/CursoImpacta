package br.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.impacta.model.ProgramadorJava;
import br.impacta.persistence.FabricaDeConexao;

public class ProgramadorJavaDao {
	public boolean salvarProgramadorJava(ProgramadorJava progJava) {
		// Cria uma flag booleana
		boolean salvo;
		
		// Comando SQL que será usado ao chamar essa função
		String cmd = "INSERT INTO programador_java(matricula, nome, email, salario, certificacao_oracle) VALUES(?, ?, ?, ?, ?)";
		
		// Instancia as variaveis de conexão e preparação de ambiente
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Tenta realizar a inserção no banco de dados
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, progJava.getMatricula());
			pstm.setString(2, progJava.getNome());
			pstm.setString(3, progJava.getEmail());
			pstm.setDouble(4, progJava.getSalario());
			pstm.setString(5, progJava.getCertificacaoOracle());
			pstm.execute();
			
			System.out.println("Programador Java salvo com sucesso!");
			salvo = true;
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir um novo programador java no banco de dados");
			salvo = false;
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salvo;
	}

	public List<ProgramadorJava> listarProgramadoresJava() {
		// Comando SQL que será usado ao chamar essa função
		String query = "SELECT * FROM programador_java";
		
		// Lista que irá armazenar os dados que serão retornados da query
		List<ProgramadorJava> listaProgramadoresJava = new ArrayList<>();
		
		// Instancia as variaveis de conexão e preparação de ambiente
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		// Tenta realizar a seleção dos dados no banco de dados
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			// Enquanto houver dados no select ele fica dentro do laço
			while(rs.next()) {
				ProgramadorJava progJava = new ProgramadorJava();
				
				progJava.setMatricula(rs.getString("matricula"));
				progJava.setNome(rs.getString("nome"));
				progJava.setEmail(rs.getString("email"));
				progJava.setSalario(rs.getDouble("salario"));
				progJava.setCertificacaoOracle(rs.getString("certificacao_oracle"));
				
				listaProgramadoresJava.add(progJava);
			}
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar todos os programadores java no banco de dados");
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(rs != null) {
					rs.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaProgramadoresJava;
	}

	public boolean atualizarProgramadorJava(ProgramadorJava progJava) {
		boolean atualizado;
		
		String cmd = "UPDATE programador_java SET matricula = ?, nome = ?, email = ? , salario = ?, certificacao_oracle = ? WHERE matricula = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, progJava.getMatricula());
			pstm.setString(2, progJava.getNome());
			pstm.setString(3, progJava.getEmail());
			pstm.setDouble(4, progJava.getSalario());
			pstm.setString(5, progJava.getCertificacaoOracle());
			pstm.setString(6, progJava.getMatricula());
			pstm.execute();
			
			System.out.println("Programador java atualizado com sucesso!");
			atualizado = true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar um programador java no banco de dados");
			atualizado = false;
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return atualizado;
	}
	
	public boolean deletarProgramadorJava(String matricula) {
		// Cria uma flag booleana
		boolean deletado;
		
		// Comando SQL que será usado ao chamar essa função
		String cmd = "DELETE FROM programador_java WHERE matricula = ?";
		
		// Instancia as variaveis de conexão e preparação de ambiente
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Tenta realizar a atualização no banco de dados
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, matricula);
			pstm.execute();
			
			System.out.println("Programador java excluido com sucesso!");
			deletado = true;
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao excluir um programador java no banco de dados");
			deletado = false;
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return deletado;
	}
}
