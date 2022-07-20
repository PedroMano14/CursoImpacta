package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorJava;
import br.impacta.repository.RepositorioProgramadorJava;

public class TelaAlterarProgramadorJavaController implements ActionListener {

	JTextField matriculaTextField;
	JTextField nomeTextField;
	JTextField txtSalarioUser;
	JTextField emailTextField;
	JTextField certificacaoTextField;
	ProgramadorJava ProgramadorJavaAtual;
	RepositorioProgramadorJava repositorioProgramadorJava;
	JFrame frameMenuInicialProgramadorJava;
	JFrame frameTelaAlterarProgramadorJava;

	boolean salvo = false;

	public TelaAlterarProgramadorJavaController(ProgramadorJava ProgramadorJavaAtual, JTextField nomeTextField,
			JTextField emailTextField, JTextField certificacaoOracleTextField, JTextField txtSalarioUser,
			RepositorioProgramadorJava repositorioProgramadorJava, JFrame frameMenuInicialProgramadorJava,
			JFrame frameTelaAlterarProgramadorJava) {
		super();
		this.nomeTextField = nomeTextField;
		this.emailTextField = emailTextField;
		this.txtSalarioUser = txtSalarioUser;
		this.certificacaoTextField = certificacaoOracleTextField;
		this.repositorioProgramadorJava = repositorioProgramadorJava;
		this.frameMenuInicialProgramadorJava = frameMenuInicialProgramadorJava;
		this.frameTelaAlterarProgramadorJava = frameTelaAlterarProgramadorJava;
		this.ProgramadorJavaAtual = ProgramadorJavaAtual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarAlterar();
		frameMenuInicialProgramadorJava.setVisible(true);
		frameTelaAlterarProgramadorJava.setVisible(false);

	}

	public void acionarAlterar() {
		ProgramadorJava programadorJavaNovo = new ProgramadorJava();
		programadorJavaNovo.setMatricula(ProgramadorJavaAtual.getMatricula());
		programadorJavaNovo.setNome(nomeTextField.getText());
		programadorJavaNovo.setEmail(emailTextField.getText());
		programadorJavaNovo.setSalario(programadorJavaNovo.calcularSalario(Integer.parseInt(txtSalarioUser.getText())));
		programadorJavaNovo.setCertificacaoOracle(certificacaoTextField.getText());

		salvo = repositorioProgramadorJava.alterarProgramadorJava(ProgramadorJavaAtual, programadorJavaNovo);
		if (salvo) {

			JOptionPane.showMessageDialog(null, programadorJavaNovo.getNome() + " Foi Alterado!!!");

		} else {
			JOptionPane.showMessageDialog(null, "#ERRO# ProgramadorJava Não Alterado!!");
		}

	}

}
