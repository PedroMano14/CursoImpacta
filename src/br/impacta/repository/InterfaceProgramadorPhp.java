package br.impacta.repository;

import java.util.List;

import br.impacta.model.ProgramadorPhp;

public interface InterfaceProgramadorPhp {

	public boolean salvarProgramadorPhp(ProgramadorPhp programadorPhp);

	public List<ProgramadorPhp> listarProgramadorPhp();

	public boolean deletarProgramadorPhp(String matricula);

	public ProgramadorPhp buscarProgramadorPhp(String matricula);

	public boolean alterarProgramadorPhp(ProgramadorPhp programadorPhprNovo, ProgramadorPhp programadorPhpAtual);
}
