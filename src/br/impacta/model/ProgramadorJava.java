package br.impacta.model;

public class ProgramadorJava extends Programador{
	
	private String certificacaoOracle;

	public String getCertificacaoOracle() {
		return certificacaoOracle;
	}

	public void setCertificacaoOracle(String certificacaoOracle) {
		this.certificacaoOracle = certificacaoOracle;
	}

	@Override
	public double calcularSalario(int horasTrabalhadas) {
		double salario = horasTrabalhadas * 120; 
		return salario;
	}

	@Override
	public int calcularHorasTrabalhadas(double salario) {
		int horasTrabalhadas = (int) (salario / 120); 
		return horasTrabalhadas;
	}
}