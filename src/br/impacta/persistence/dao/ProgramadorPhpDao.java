package br.impacta.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.impacta.model.ProgramadorPhp;
import br.impacta.persistence.FabricaDeConexao;

public class ProgramadorPhpDao {
	public boolean salvarProgramadorPhp(ProgramadorPhp progPhp) {
		boolean salvo;

		String cmd = "INSERT INTO programador_php(matricula, nome, email, salario, certificacao_php) VALUES(?, ?,?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(2, progPhp.getNome());
			pstm.setString(3, progPhp.getEmail());
			pstm.setDouble(4, progPhp.getSalario());
			pstm.setString(5, progPhp.getPhp());
			pstm.setString(1, progPhp.getMatricula());
			pstm.execute();

			System.out.println("Programador PHP salvo com sucesso!");
			salvo = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir um novo programador PHP no banco de dados");
			salvo = false;
		} finally {
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
		String query = "SELECT * FROM programador_php";

		List<ProgramadorPhp> listaProgramadoresPhp = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {
				ProgramadorPhp progPhp = new ProgramadorPhp();

				progPhp.setMatricula(rs.getString("matricula"));
				progPhp.setNome(rs.getString("nome"));
				progPhp.setEmail(rs.getString("email"));
				progPhp.setSalario(rs.getDouble("salario"));
				progPhp.setPhp(rs.getString("certificacao_php"));

				listaProgramadoresPhp.add(progPhp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar todos os programadores PHP no banco de dados");
		} finally {
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

		String cmd = "UPDATE programador_php SET matricula = ?, nome = ?, email=?, salario = ?, certificacao_php = ? WHERE matricula = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			
			pstm.setString(1, progPhp.getMatricula());
			pstm.setString(2, progPhp.getNome());
			pstm.setString(3, progPhp.getEmail());
			pstm.setDouble(4, progPhp.getSalario());
			pstm.setString(5, progPhp.getPhp());
			pstm.setString(6, progPhp.getMatricula());
			pstm.execute();

			System.out.println("Programador PHP atualizado com sucesso!");
			atualizado = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar um programador PHP no banco de dados");
			atualizado = false;
		} finally {
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
		boolean deletado;

		String cmd = "DELETE FROM programador_php WHERE matricula = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(cmd);
			pstm.setString(1, matricula);
			pstm.execute();

			System.out.println("Programador PHP excluido com sucesso!");
			deletado = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao excluir um programador PHP no banco de dados");
			deletado = false;
		} finally {
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
