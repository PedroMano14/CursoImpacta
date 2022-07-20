package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.controller.TelaCadastroProgramadorJavaController;

public class TelaCadastroProgramadorJava {

	public void abrirTelaCadastroProgramadorJava(RepositorioProgramadorJava repositorioProgramadorJava,
			JFrame frameMenuInicialProgramadorJava) {

		String nomeTexto = "Digite o nome do Programador Java:";
		String emailTexto = "Digite o e-mail do Programador Java:";
		String certificacaoTexto = "Digite a certificacao do Programador Java:";

		JFrame frameTelaCadastroProgramadorJava = new JFrame();
		frameTelaCadastroProgramadorJava.setSize(200, 400);
		frameTelaCadastroProgramadorJava.setTitle("Cadastro de Programador Java");
		frameTelaCadastroProgramadorJava.setLocation(300, 300);

		JPanel panelTelaCadastroProgramadorJava = new JPanel();

		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		panelTelaCadastroProgramadorJava.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		panelTelaCadastroProgramadorJava.add(nomeTextField);

		JLabel emailTextLabel = new JLabel(emailTexto);
		panelTelaCadastroProgramadorJava.add(emailTextLabel);

		JTextField emailTextField = new JTextField(10);
		panelTelaCadastroProgramadorJava.add(emailTextField);

		JLabel certificacaoTextLabel = new JLabel(certificacaoTexto);
		panelTelaCadastroProgramadorJava.add(certificacaoTextLabel);

		JTextField certificacaoTextField = new JTextField(10);
		panelTelaCadastroProgramadorJava.add(certificacaoTextField);

		JLabel lblSalarioProgramadorJava = new JLabel("Digite as horas trabalhadas do programador java");
		panelTelaCadastroProgramadorJava.add(lblSalarioProgramadorJava);

		JTextField txtSalarioProgramadorJava = new JTextField(23);
		panelTelaCadastroProgramadorJava.add(txtSalarioProgramadorJava);

		JButton buttonCadastroProgramadorJava = new JButton("Registrar");
		panelTelaCadastroProgramadorJava.add(buttonCadastroProgramadorJava);

		frameTelaCadastroProgramadorJava.add(panelTelaCadastroProgramadorJava);

		frameTelaCadastroProgramadorJava.setVisible(true);

		TelaCadastroProgramadorJavaController telaCadastroProgramadorJavaController = new TelaCadastroProgramadorJavaController(
				nomeTextField, emailTextField, certificacaoTextField, txtSalarioProgramadorJava,
				repositorioProgramadorJava, frameMenuInicialProgramadorJava, frameTelaCadastroProgramadorJava);

		buttonCadastroProgramadorJava.addActionListener(telaCadastroProgramadorJavaController);

	}
}
