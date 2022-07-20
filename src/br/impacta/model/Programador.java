package br.impacta.model;

public class Programador {

	private String matricula;
	private String nome;
	private String email;
	private double salario;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double calcularSalario(int horasTrabalhadas) {
		double salario = horasTrabalhadas * 7.5; 
		return salario;
	}

	public int calcularHorasTrabalhadas(double salario) {
		int horasTrabalhadas = (int) (salario / 7.5); 
		return horasTrabalhadas;
	}
}
