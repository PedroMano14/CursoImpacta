package br.impacta.view.service;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;

public class ValidaProgramadorPhp {

	public String validarProgramadorPhp(ProgramadorPhp ProgramadorPhp, RepositorioProgramadorPhp repositorio) {
		String mensagemErro = null;

		if ((repositorio.buscarProgramadorPhp(ProgramadorPhp.getMatricula()) != null)) {
			mensagemErro = "Matricula de Programador Php Repetida";
			return mensagemErro;
		}
		if (ProgramadorPhp.getNome().length() > 20) {
			mensagemErro = "Maximo de 20 caracteres para o nome do Programador Php!";
			return mensagemErro;
		}
		if (ProgramadorPhp.getEmail().length() > 30) {
			mensagemErro = "Maximo de 15 caracteres para o email do Programador Php!";
			return mensagemErro;
		}
		if (ProgramadorPhp.getPhp().length() > 30) {
			mensagemErro = "Maximo de 15 caracteres para a certificação do Programador Php!";
			return mensagemErro;
		}


		return mensagemErro;
	}
}
