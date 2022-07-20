package br.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.impacta.model.ProgramadorPhp;
import br.impacta.persistence.FabricaDeConexao;

public class ProgramadorPhpDao {
	public boolean salvarProgramadorPhp(ProgramadorPhp progPhp) {
		// Cria uma flag booleana
		boolean salvo;

		// Comando SQL que será usado ao chamar essa função
		String cmd = "INSERT INTO programador_php(matricula, nome, email, salario, certificacao_php) VALUES(?, ?, ?, ?, ?)";

		// Instancia as variaveis de conexão e preparação de ambiente
		Connection conn = null;
		PreparedStatement pstm = null;

		// Tenta realizar a inserção no banco de dados
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, progPhp.getMatricula());
			pstm.setString(2, progPhp.getNome());
			pstm.setString(3, progPhp.getEmail());
			pstm.setDouble(4, progPhp.getSalario());
			pstm.setString(5, progPhp.getPhp());
			pstm.execute();

			System.out.println("Programador PHP salvo com sucesso!");
			salvo = true;
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir um novo programador PHP no banco de dados");
			salvo = false;
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return salvo;
	}

	public List<ProgramadorPhp> listarProgramadoresPhp() {
		// Comando SQL que será usado ao chamar essa função
		String query = "SELECT * FROM programador_php";

		// Lista que irá armazenar os dados que serão retornados da query
		List<ProgramadorPhp> listaProgramadoresPhp = new ArrayList<>();

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
			while (rs.next()) {
				ProgramadorPhp progPhp = new ProgramadorPhp();

				progPhp.setMatricula(rs.getString("matricula"));
				progPhp.setNome(rs.getString("nome"));
				progPhp.setEmail(rs.getString("email"));
				progPhp.setSalario(rs.getDouble("salario"));
				progPhp.setPhp(rs.getString("certificacao_php"));

				listaProgramadoresPhp.add(progPhp);
			}
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar todos os programadores PHP no banco de dados");
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaProgramadoresPhp;
	}

	public boolean atualizarProgramadorPhp(ProgramadorPhp progPhp) {
		boolean atualizado;

		String cmd = "UPDATE programador_php SET nome = ?, email = ? , salario = ?, certificacao_php = ? WHERE matricula = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(5, progPhp.getMatricula());
			pstm.setString(1, progPhp.getNome());
			pstm.setString(2, progPhp.getEmail());
			pstm.setDouble(3, progPhp.getSalario());
			pstm.setString(4, progPhp.getPhp());
			pstm.execute();

			System.out.println("Programador PHP atualizado com sucesso!");
			atualizado = true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar um programador PHP no banco de dados");
			atualizado = false;
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return atualizado;
	}

	public boolean deletarProgramadorPhp(String matricula) {
		// Cria uma flag booleana
		boolean deletado;

		// Comando SQL que será usado ao chamar essa função
		String cmd = "DELETE FROM programador_php WHERE matricula = ?";

		// Instancia as variaveis de conexão e preparação de ambiente
		Connection conn = null;
		PreparedStatement pstm = null;

		// Tenta realizar a atualização no banco de dados
		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, matricula);
			pstm.execute();

			System.out.println("Programador PHP excluido com sucesso!");
			deletado = true;
		}
		// Retorna erro caso não consiga inserir
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao excluir um programador PHP no banco de dados");
			deletado = false;
		}
		// Fecha a conexão caso ela ainda esteja aberta
		finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return deletado;
	}
}
