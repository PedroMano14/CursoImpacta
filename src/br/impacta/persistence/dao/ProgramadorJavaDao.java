package br.impacta.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.impacta.model.ProgramadorJava;
import br.impacta.persistence.FabricaDeConexao;

public class ProgramadorJavaDao {

	public boolean salvaNoBanco(ProgramadorJava programadorJava) {

		boolean salvo;

		String sql = "INSERT INTO gerente (matricula, nome, email, salario, certificacao) VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, programadorJava.getMatricula());
			pstm.setString(2, programadorJava.getNome());
			pstm.setString(3, programadorJava.getEmail());
			pstm.setDouble(4, programadorJava.getSalario());
			pstm.setString(5, programadorJava.getCertificacaoOracle());

			pstm.execute();

			System.out.println("Progamador Java salvo com sucesso!!");
			salvo = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu erro na DAO - SALVAR");
			salvo = false;
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();

				}
			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return salvo;

	}

	public List<ProgramadorJava> BuscarListaProgramadorJava() {

		String sql = "SELECT * FROM programadorJava";
		List<ProgramadorJava> programadoresJava = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				ProgramadorJava programadorJava = new ProgramadorJava();

				programadorJava.setMatricula(rset.getString("matricula"));
				programadorJava.setNome(rset.getString("nome"));
				programadorJava.setEmail(rset.getString("email"));
				programadorJava.setSalario(rset.getDouble("salario"));
				programadorJava.setCertificacaoOracle(rset.getString("certificacao"));
				programadoresJava.add(programadorJava);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar");
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return programadoresJava;

	}

	public boolean deletarPelaMatricula(String matricula) {
		String sql = "DELETE FROM programadorJava WHERE matricula = ?";

		boolean deletado = false;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, matricula);
			pstm.execute();
			deletado = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao deletar.");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao encerrar conexão");
			}

		}
		return deletado;

	}

	public boolean alterarProgramadorJavaNoBanco(ProgramadorJava programadorJava) {
		String sql = "UPDATE programadorJava SET matricula = ?,nome = ?, email = ?, certificacao = ? WHERE matricula = ? ";

		boolean alterado = false;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = FabricaDeConexao.criaConexaoComMySql();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, programadorJava.getMatricula());
			pstm.setString(2, programadorJava.getNome());
			pstm.setString(3, programadorJava.getEmail());
			pstm.setString(4, programadorJava.getCertificacaoOracle());
			pstm.setString(5, programadorJava.getMatricula());

			pstm.execute();
			alterado = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao alterar");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao encerrar conexão");
			}

		}
		return alterado;

	}

}
