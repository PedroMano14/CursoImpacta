package br.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.impacta.dao.ProgramadorJavaDao;
import br.impacta.model.ProgramadorJava;

public class RepositorioProgramadorJava implements InterfaceProgramadorJava {

	List<ProgramadorJava> listaDeProgramadoresJava = new ArrayList<>();
	ProgramadorJavaDao javaDao = new ProgramadorJavaDao();

	@Override
	public boolean salvarProgramadorJava(ProgramadorJava programadorJava) {

		boolean salvo;

		salvo = javaDao.salvarProgramadorJava(programadorJava);

		return salvo;
	}

	@Override
	public List<ProgramadorJava> listarProgramadorJava() {

		return javaDao.listarProgramadoresJava();
	}

	@Override
	public boolean deletarProgramadorJava(String matricula) {

		boolean deletado;
		deletado = javaDao.deletarProgramadorJava(matricula);
		return deletado;
	}

	@Override
	public ProgramadorJava buscarProgramadorJava(String matricula) {

		for (ProgramadorJava progJava : javaDao.listarProgramadoresJava()) {
			if (progJava.getMatricula().equals(matricula)) {
				return progJava;
			}
		}

		return null;
	}

	@Override
	public boolean alterarProgramadorJava(ProgramadorJava programadorJavaAtual, ProgramadorJava programadorJavaNovo) {

		boolean atualizado;
		atualizado = javaDao.atualizarProgramadorJava(programadorJavaNovo);
		return atualizado;

	}
}
