package br.impacta.view.service;

import br.impacta.repository.RepositorioProgramadorJava;

public class GerarMatriculaJava {

	RepositorioProgramadorJava repositorioProgramadorJava = new RepositorioProgramadorJava();
	public String gerarMatriculaProgramadorJava() {
		String matriculaGerada = null;
		int quantidadeProgramadorJavas = repositorioProgramadorJava.listarProgramadorJava().size();
		quantidadeProgramadorJavas++;
		
		matriculaGerada = ("IMPGE00" +quantidadeProgramadorJavas++);
		
		return matriculaGerada;
	}

}
