package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.service.GerarMatriculaPhp;
import br.impacta.view.service.ValidaProgramadorPhp;

public class TelaCadastroProgramadorPhpController implements ActionListener {
	JTextField nomeTextField;
	JTextField emailTextField;
	JTextField phpTextField;
	JTextField txtSalarioProgramadorPhp;
	RepositorioProgramadorPhp repositorioProgramadorPhp;
	JFrame frameMenuInicialProgramadorPhp;
	JFrame frameTelaCadastroProgramadorPhp;
	String mensagemErro = null;

	boolean salvo;

	public TelaCadastroProgramadorPhpController(JTextField nomeTextField, JTextField emailTextField,
			JTextField phpTextField, JTextField txtSalarioProgramadorPhp,
			RepositorioProgramadorPhp repositorioProgramadorPhp, JFrame frameMenuInicialProgramadorPhp,
			JFrame frameTelaCadastroProgramadorPhp) {
		super();
		this.nomeTextField = nomeTextField;
		this.emailTextField = emailTextField;
		this.phpTextField = phpTextField;
		this.txtSalarioProgramadorPhp = txtSalarioProgramadorPhp;
		this.repositorioProgramadorPhp = repositorioProgramadorPhp;
		this.frameMenuInicialProgramadorPhp = frameMenuInicialProgramadorPhp;
		this.frameTelaCadastroProgramadorPhp = frameTelaCadastroProgramadorPhp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (acionarSalvar() == null) {
			frameMenuInicialProgramadorPhp.setVisible(true);
			frameTelaCadastroProgramadorPhp.setVisible(false);
		}

	}

	public String acionarSalvar() {
		ProgramadorPhp programadorPhp = new ProgramadorPhp();
		ValidaProgramadorPhp validaProgramadorPhp = new ValidaProgramadorPhp();
		GerarMatriculaPhp matriculaPhp = new GerarMatriculaPhp();

		programadorPhp.setMatricula(matriculaPhp.gerarMatriculaProgramadorPhp());
		programadorPhp.setNome(nomeTextField.getText());
		programadorPhp.setEmail(emailTextField.getText());
		programadorPhp.setPhp(phpTextField.getText());
		programadorPhp.setSalario(programadorPhp.calcularSalario(Integer.parseInt(txtSalarioProgramadorPhp.getText())));

		mensagemErro = validaProgramadorPhp.validarProgramadorPhp(programadorPhp, repositorioProgramadorPhp);

		if (mensagemErro == null) {
		
			salvo = repositorioProgramadorPhp.salvarProgramadorPhp(programadorPhp);
			if (salvo) {
				JOptionPane.showMessageDialog(null, programadorPhp.getNome() + " Foi Registrado");
				return mensagemErro;

			} else {
				JOptionPane.showMessageDialog(null, programadorPhp.getNome() + "Erro!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, mensagemErro);
		}
		return mensagemErro;
	}

}
