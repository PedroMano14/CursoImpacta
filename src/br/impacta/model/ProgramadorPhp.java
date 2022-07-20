package br.impacta.model;

public class ProgramadorPhp extends Programador{
	
	private String php;

	public String getPhp() {
		return php;
	}

	public void setPhp(String php) {
		this.php = php;
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