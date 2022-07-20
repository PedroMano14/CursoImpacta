package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.controller.TelaMenuProgramadorJavaController;

public class TelaMenuProgramadorJava {
	
	public void apresentarMenuProgramadorJava(RepositorioProgramadorJava repositorioProgramadorJava) {
		
		String menuInicialTexto = "##Menu Inicial Programador Java##";
		String opcaoUmMenuTexto = "[1] Cadastrar Programador Java";
		String opcaoDoisMenuTexto = "[2] Listar Programador Java    ";
		String opcaoTresMenuTexto = "[3] Deletar";
		String opcaoQuatroMenuTexto = "[4] Alterar Programador Java ";
		String opcaoCincoMenuTexto = "[5] Voltar Menu Inicial ";
		String opcaoSeisMenuTexto = "[6] Encerrar";
		
		JFrame frameMenuInicialProgramadorJava = new JFrame();
		frameMenuInicialProgramadorJava.setSize(200, 250);
		frameMenuInicialProgramadorJava.setTitle("Cadastro de Programador Java");
		frameMenuInicialProgramadorJava.setLocation(300,300);
		
		JPanel panelMenuInicial = new JPanel();
		
		JLabel menuInicialLabel = new JLabel(menuInicialTexto);
		panelMenuInicial.add(menuInicialLabel);
		
		JLabel opcaoUmMenuLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuInicial.add(opcaoUmMenuLabel);
		
		JLabel opcaoDoisMenuLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuInicial.add(opcaoDoisMenuLabel);
		
		JLabel opcaoTresMenuLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuInicial.add(opcaoTresMenuLabel);
		
		JLabel opcaoQuatroMenuLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuInicial.add(opcaoQuatroMenuLabel);
		
		JLabel opcaoCincoMenuLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuInicial.add(opcaoCincoMenuLabel);
		
		JLabel opcaoSeisMenuLabel = new JLabel(opcaoSeisMenuTexto);
		panelMenuInicial.add(opcaoSeisMenuLabel);
		
		JTextField opcaoMenuProgramadorJavaJTextField  = new JTextField(10);
		
		panelMenuInicial.add(opcaoMenuProgramadorJavaJTextField);
		
		JButton buttonMenu = new JButton("Enviar");
		
		panelMenuInicial.add(buttonMenu);
		
		frameMenuInicialProgramadorJava.add(panelMenuInicial);
		
		frameMenuInicialProgramadorJava.setVisible(true);

		TelaMenuProgramadorJavaController telaMenuProgramadorJavaController = new TelaMenuProgramadorJavaController(frameMenuInicialProgramadorJava,opcaoMenuProgramadorJavaJTextField, repositorioProgramadorJava);
		buttonMenu.addActionListener(telaMenuProgramadorJavaController);
	}

}
