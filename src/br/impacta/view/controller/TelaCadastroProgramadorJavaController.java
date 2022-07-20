package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorJava;
import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.service.GerarMatriculaJava;
import br.impacta.view.service.ValidaProgramadorJava;

public class TelaCadastroProgramadorJavaController implements ActionListener {
	JTextField nomeTextField;
	JTextField emailTextField;
	JTextField certificacaoTextField;
	JTextField txtSalarioProgramadorJava;
	RepositorioProgramadorJava repositorioProgramadorJava;
	JFrame frameMenuInicialProgramadorJava;
	JFrame frameTelaCadastroProgramadorJava;
	String mensagemErro = null;

	boolean salvo;

	public TelaCadastroProgramadorJavaController(JTextField nomeTextField, JTextField emailTextField,
			JTextField certificacaoTextField, JTextField txtSalarioProgramadorJava,
			RepositorioProgramadorJava repositorioProgramadorJava, JFrame frameMenuInicialProgramadorJava,
			JFrame frameTelaCadastroProgramadorJava) {
		super();
		this.nomeTextField = nomeTextField;
		this.emailTextField = emailTextField;
		this.certificacaoTextField = certificacaoTextField;
		this.txtSalarioProgramadorJava = txtSalarioProgramadorJava;
		this.repositorioProgramadorJava = repositorioProgramadorJava;
		this.frameMenuInicialProgramadorJava = frameMenuInicialProgramadorJava;
		this.frameTelaCadastroProgramadorJava = frameTelaCadastroProgramadorJava;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (acionarSalvar() == null) {
			frameMenuInicialProgramadorJava.setVisible(true);
			frameTelaCadastroProgramadorJava.setVisible(false);
		}

	}

	public String acionarSalvar() {
		ProgramadorJava programadorJava = new ProgramadorJava();
		ValidaProgramadorJava validaProgramadorJava = new ValidaProgramadorJava();
		GerarMatriculaJava matriculaJava = new GerarMatriculaJava();

		programadorJava.setMatricula(matriculaJava.gerarMatriculaProgramadorJava());
		programadorJava.setNome(nomeTextField.getText());
		programadorJava.setEmail(emailTextField.getText());
		programadorJava.setCertificacaoOracle(certificacaoTextField.getText());
		programadorJava.setSalario(programadorJava.calcularSalario(Integer.parseInt(txtSalarioProgramadorJava.getText())));

		mensagemErro = validaProgramadorJava.validarProgramadorJava(programadorJava, repositorioProgramadorJava);

		if (mensagemErro == null) {
		
			salvo = repositorioProgramadorJava.salvarProgramadorJava(programadorJava);
			if (salvo) {
				JOptionPane.showMessageDialog(null, programadorJava.getNome() + " Foi Registrado");
				return mensagemErro;

			} else {
				JOptionPane.showMessageDialog(null, programadorJava.getNome() + "Erro!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, mensagemErro);
		}
		return mensagemErro;
	}

}
