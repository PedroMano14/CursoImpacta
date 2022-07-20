package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.TelaMenuProgramadorJava;
import br.impacta.view.TelaMenuProgramadorPhp;

public class MenuInicialController implements ActionListener{


	//Recebe da classe tela MenuInicial_07_07
	JTextField	opcaoMenuJTextField;
	JFrame  frameMenuInicial;
	
	//Variaveis criadas aqui - Local
	RepositorioProgramadorPhp repositorioProgramadorPhp = new RepositorioProgramadorPhp();
	TelaMenuProgramadorPhp telaMenuProgramadorPhp = new TelaMenuProgramadorPhp();
	RepositorioProgramadorJava repositorioProgramadorJava = new RepositorioProgramadorJava();
	TelaMenuProgramadorJava telaMenuProgramadorJava = new TelaMenuProgramadorJava();
	

	public MenuInicialController(JTextField opcaoMenuJTextField, JFrame frameMenuInicial) {
		//super();
		this.opcaoMenuJTextField = opcaoMenuJTextField;
		this.frameMenuInicial = frameMenuInicial;
	}
	
	
	//Ação do botão
	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2") || opcaoMenuJTextField.getText().equals("3")){
			frameMenuInicial.setVisible(false);
		
			switch (opcaoMenuJTextField.getText()) {
				case "2":
					telaMenuProgramadorPhp.apresentarMenuProgramadorPhp(repositorioProgramadorPhp);
				break;
				
				case "1":
					telaMenuProgramadorJava.apresentarMenuProgramadorJava(repositorioProgramadorJava);
				break;
				
				case "3":
					System.exit(0);
				break;
				
			}
				
		}else {
			
			JOptionPane.showMessageDialog(null, "Digite uma opção válida");
		}
		
				
		
	}
}
