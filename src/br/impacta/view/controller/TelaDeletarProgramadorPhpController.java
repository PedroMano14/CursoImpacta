package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorPhp;

public class TelaDeletarProgramadorPhpController implements ActionListener {
	
	RepositorioProgramadorPhp repositorioProgramadorPhp;
	JFrame frameMenuInicialProgramadorPhp;
	JFrame frameDeletarProgramadorPhp;
	JTextField matriculaField;
	
	boolean deletado;

	public TelaDeletarProgramadorPhpController(RepositorioProgramadorPhp repositorioProgramadorPhp, JFrame frameMenuInicialProgramadorPhp,
			JFrame frameDeletarProgramadorPhp, JTextField matriculaField) {
		super();
		this.repositorioProgramadorPhp = repositorioProgramadorPhp;
		this.frameMenuInicialProgramadorPhp = frameMenuInicialProgramadorPhp;
		this.frameDeletarProgramadorPhp = frameDeletarProgramadorPhp;
		this.matriculaField = matriculaField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		deletado = repositorioProgramadorPhp.deletarProgramadorPhp(matriculaField.getText());
		frameDeletarProgramadorPhp.setVisible(false);
		frameMenuInicialProgramadorPhp.setVisible(true);
		
		if(deletado) {
			JOptionPane.showMessageDialog(null, "Programador Php Deletado");
		
		}else {
			JOptionPane.showMessageDialog(null, "Programador Php Não Encontrado");
			
		}
		
	}

}
