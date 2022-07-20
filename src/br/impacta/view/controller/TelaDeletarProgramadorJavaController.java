package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorJava;

public class TelaDeletarProgramadorJavaController implements ActionListener {
	
	RepositorioProgramadorJava repositorioProgramadorJava;
	JFrame frameMenuInicialProgramadorJava;
	JFrame frameDeletarProgramadorJava;
	JTextField matriculaField;
	
	boolean deletado;

	public TelaDeletarProgramadorJavaController(RepositorioProgramadorJava repositorioProgramadorJava, JFrame frameMenuInicialProgramadorJava,
			JFrame frameDeletarProgramadorJava, JTextField matriculaField) {
		super();
		this.repositorioProgramadorJava = repositorioProgramadorJava;
		this.frameMenuInicialProgramadorJava = frameMenuInicialProgramadorJava;
		this.frameDeletarProgramadorJava = frameDeletarProgramadorJava;
		this.matriculaField = matriculaField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		deletado = repositorioProgramadorJava.deletarProgramadorJava(matriculaField.getText());
		frameDeletarProgramadorJava.setVisible(false);
		frameMenuInicialProgramadorJava.setVisible(true);
		
		if(deletado) {
			JOptionPane.showMessageDialog(null, "Programador Java Deletado");
		
		}else {
			JOptionPane.showMessageDialog(null, "Programador Java Não Encontrado");
			
		}
		
	}

}
