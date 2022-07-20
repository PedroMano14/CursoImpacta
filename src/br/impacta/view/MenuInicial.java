package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.view.controller.MenuInicialController;

public class MenuInicial {


	public void apresentarMenuInicial() {
		
		
		String menuInicialTexto = "Menu Inicial";
		String opcaoUmMenuTexto = "[1] Menu Programador Java";
		String opcaoDoisMenuTexto = "[2]  Menu Programador PHP";
		String opcaoTresMenuTexto = "[3] Encerrar";

		
		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200, 220);
		frameMenuInicial.setTitle("Cadastro de Funcionario");
		frameMenuInicial.setLocation(300,300);
		
		JPanel panelMenuInicial = new JPanel();
		
		JLabel menuInicialLabel = new JLabel(menuInicialTexto);
		panelMenuInicial.add(menuInicialLabel);
		
		JLabel opcaoUmMenuLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuInicial.add(opcaoUmMenuLabel);
		
		JLabel opcaoDoisMenuLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuInicial.add(opcaoDoisMenuLabel);
		
		JLabel opcaoTresMenuLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuInicial.add(opcaoTresMenuLabel);
		
		JTextField opcaoMenuJTextField  = new JTextField(10);
		panelMenuInicial.add(opcaoMenuJTextField);
		
		JButton buttonMenu = new JButton("Enviar");
		panelMenuInicial.add(buttonMenu);

		
		frameMenuInicial.add(panelMenuInicial);
		frameMenuInicial.setVisible(true);

		MenuInicialController menuInicialController = new MenuInicialController(opcaoMenuJTextField,frameMenuInicial); 

		buttonMenu.addActionListener(menuInicialController);	
	}
}
