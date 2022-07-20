package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;

public class TelaAlterarProgramadorPhpController implements ActionListener {

	JTextField nomeTextField;
	JTextField emailTextField;
	JTextField txtSalarioProgramadorPhp;
	JTextField phpTextField;
	ProgramadorPhp ProgramadorPhpAtual;
	RepositorioProgramadorPhp repositorioProgramadorPhp;
	JFrame frameMenuInicialProgramadorPhp;
	JFrame frameTelaAlterarProgramadorPhp;

	boolean salvo = false;

	public TelaAlterarProgramadorPhpController(ProgramadorPhp ProgramadorPhpAtual, JTextField nomeTextField,
			JTextField emailTextField, JTextField txtSalarioProgramadorPhp, JTextField phpTextField,
			RepositorioProgramadorPhp repositorioProgramadorPhp, JFrame frameMenuInicialProgramadorPhp,
			JFrame frameTelaAlterarProgramadorPhp) {
		super();
		this.nomeTextField = nomeTextField;
		this.emailTextField = emailTextField;
		this.txtSalarioProgramadorPhp = txtSalarioProgramadorPhp;
		this.phpTextField = phpTextField;
		this.repositorioProgramadorPhp = repositorioProgramadorPhp;
		this.frameMenuInicialProgramadorPhp = frameMenuInicialProgramadorPhp;
		this.frameTelaAlterarProgramadorPhp = frameTelaAlterarProgramadorPhp;
		this.ProgramadorPhpAtual = ProgramadorPhpAtual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarAlterar();
		frameMenuInicialProgramadorPhp.setVisible(true);
		frameTelaAlterarProgramadorPhp.setVisible(false);

	}

	public void acionarAlterar() {
		ProgramadorPhp ProgramadorPhpNovo = new ProgramadorPhp();
		ProgramadorPhpNovo.setMatricula(ProgramadorPhpAtual.getMatricula());
		ProgramadorPhpNovo.setNome(nomeTextField.getText());
		ProgramadorPhpNovo.setEmail(emailTextField.getText());
		ProgramadorPhpNovo.setPhp(phpTextField.getText());
		ProgramadorPhpNovo
				.setSalario(ProgramadorPhpNovo.calcularSalario(Integer.parseInt(txtSalarioProgramadorPhp.getText())));

		salvo = repositorioProgramadorPhp.alterarProgramadorPhp(ProgramadorPhpAtual, ProgramadorPhpNovo);
		if (salvo) {

			JOptionPane.showMessageDialog(null, ProgramadorPhpNovo.getNome() + " Foi Alterado!!!");

		} else {
			JOptionPane.showMessageDialog(null, "#ERRO# ProgramadorPhp Não Alterado!!");
		}

	}
}
