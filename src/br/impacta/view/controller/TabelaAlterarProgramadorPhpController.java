package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.TelaAlterarProgramadorPhp;

public class TabelaAlterarProgramadorPhpController implements ActionListener{

	RepositorioProgramadorPhp repositorioProgramadorPhp;
	JFrame frameMenuInicialProgramadorPhp;
	JFrame frameAlterarProgramadorPhp;
	JTextField matriculaField;
	ProgramadorPhp ProgramadorPhpAtual = new ProgramadorPhp();
	TelaAlterarProgramadorPhp telalterarProgramadorPhp =  new TelaAlterarProgramadorPhp();
	
	
	
	public TabelaAlterarProgramadorPhpController(RepositorioProgramadorPhp repositorioProgramadorPhp, JFrame frameMenuInicialProgramadorPhp,
			JFrame frameAlterarProgramadorPhp, JTextField matriculaField) {
		super();
		this.repositorioProgramadorPhp = repositorioProgramadorPhp;
		this.frameMenuInicialProgramadorPhp = frameMenuInicialProgramadorPhp;
		this.frameAlterarProgramadorPhp = frameAlterarProgramadorPhp;
		this.matriculaField = matriculaField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProgramadorPhpAtual = repositorioProgramadorPhp.buscarProgramadorPhp(matriculaField.getText());
		frameAlterarProgramadorPhp.setVisible(false);
		if(ProgramadorPhpAtual != null) {
			telalterarProgramadorPhp.abrirTelaAlterarProgramadorPhp(ProgramadorPhpAtual, repositorioProgramadorPhp, frameMenuInicialProgramadorPhp);
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "ProgramadorPhp Não encontrado");
			frameMenuInicialProgramadorPhp.setVisible(true);
		}
		
	}
}
