package br.impacta.repository;

import java.util.ArrayList;
import java.util.List;

import br.impacta.dao.ProgramadorPhpDao;
import br.impacta.model.ProgramadorPhp;

public class RepositorioProgramadorPhp implements InterfaceProgramadorPhp {

	List<ProgramadorPhp> listaDeProgramadoresPhp = new ArrayList<>();
	ProgramadorPhpDao phpDao = new ProgramadorPhpDao();

	@Override
	public boolean salvarProgramadorPhp(ProgramadorPhp programadorPhp) {

		boolean salvo;

		salvo = phpDao.salvarProgramadorPhp(programadorPhp);

		return salvo;
	}

	@Override
	public List<ProgramadorPhp> listarProgramadorPhp() {

		return phpDao.listarProgramadoresPhp();
	}

	@Override
	public boolean deletarProgramadorPhp(String matricula) {

		boolean deletado;

		deletado = phpDao.deletarProgramadorPhp(matricula);

		return deletado;
	}

	@Override
	public ProgramadorPhp buscarProgramadorPhp(String matricula) {

		for (ProgramadorPhp progPhp : phpDao.listarProgramadoresPhp()) {
			if (progPhp.getMatricula().equals(matricula)) {
				return progPhp;
			}
		}

		return null;
	}

	@Override
	public boolean alterarProgramadorPhp(ProgramadorPhp programadorPhpAtual, ProgramadorPhp programadorPhpNovo) {

		boolean atualizado;
		atualizado = phpDao.atualizarProgramadorPhp(programadorPhpNovo);
		return atualizado;

	}
}
