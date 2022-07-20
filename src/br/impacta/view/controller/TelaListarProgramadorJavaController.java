package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TelaListarProgramadorJavaController implements ActionListener {
	
	JFrame frameMenuInicialProgramadorJava;
	JFrame frameListarProgramadorJava;

	public TelaListarProgramadorJavaController(JFrame frameMenuInicialProgramadorJava, JFrame frameListarProgramadorJava) {
		super();
		this.frameMenuInicialProgramadorJava = frameMenuInicialProgramadorJava;
		this.frameListarProgramadorJava = frameListarProgramadorJava;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frameMenuInicialProgramadorJava.setVisible(true);
		frameListarProgramadorJava.setVisible(false);
		
	}

}
