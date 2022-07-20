package br.impacta.view.service;

import br.impacta.model.ProgramadorJava;
import br.impacta.repository.RepositorioProgramadorJava;

public class ValidaProgramadorJava {

	public String validarProgramadorJava(ProgramadorJava ProgramadorJava, RepositorioProgramadorJava repositorio) {
		String mensagemErro = null;

		if ((repositorio.buscarProgramadorJava(ProgramadorJava.getMatricula()) != null)) {
			mensagemErro = "Matricula de ProgramadorJava Repetida";
			return mensagemErro;
		}
		if (ProgramadorJava.getNome().length() > 20) {
			mensagemErro = "Maximo de 20 caracteres para o nome do ProgramadorJava!";
			return mensagemErro;
		}
		if (ProgramadorJava.getEmail().length() > 30) {
			mensagemErro = "Maximo de 15 caracteres para o email do ProgramadorJava!";
			return mensagemErro;
		}
		if (ProgramadorJava.getCertificacaoOracle().length() > 30) {
			mensagemErro = "Maximo de 15 caracteres para a certificação do ProgramadorJava!";
			return mensagemErro;
		}

		return mensagemErro;
	}

}
