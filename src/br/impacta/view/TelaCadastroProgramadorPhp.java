package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.controller.TelaCadastroProgramadorPhpController;

public class TelaCadastroProgramadorPhp {

	public void abrirTelaCadastroProgramadorPhp(RepositorioProgramadorPhp repositorioProgramadorPhp,
			JFrame frameMenuInicialProgramadorPhp) {

		String nomeTexto = "Digite o nome do programador Php:";
		String emailTexto = "Digite o e-mail do programador Php:";
		String phpTexto = "Digite o nível do programador Php:";

		JFrame frameTelaCadastroProgramadorPhp = new JFrame();
		frameTelaCadastroProgramadorPhp.setSize(200, 400);
		frameTelaCadastroProgramadorPhp.setTitle("Cadastro de Programador Php");
		frameTelaCadastroProgramadorPhp.setLocation(300, 300);

		JPanel panelTelaCadastroProgramadorPhp = new JPanel();

		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		panelTelaCadastroProgramadorPhp.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		panelTelaCadastroProgramadorPhp.add(nomeTextField);

		JLabel emailTextLabel = new JLabel(emailTexto);
		panelTelaCadastroProgramadorPhp.add(emailTextLabel);

		JTextField emailTextField = new JTextField(10);
		panelTelaCadastroProgramadorPhp.add(emailTextField);

		JLabel phpTextLabel = new JLabel(phpTexto);
		panelTelaCadastroProgramadorPhp.add(phpTextLabel);

		JTextField phpTextField = new JTextField(10);
		panelTelaCadastroProgramadorPhp.add(phpTextField);

		JLabel lblSalarioProgramadorPhp = new JLabel("Digite as horas trabalhadas do programador php");
		panelTelaCadastroProgramadorPhp.add(lblSalarioProgramadorPhp);

		JTextField txtSalarioProgramadorPhp = new JTextField(23);
		panelTelaCadastroProgramadorPhp.add(txtSalarioProgramadorPhp);

		JButton buttonCadastroProgramadorPhp = new JButton("Registrar");
		panelTelaCadastroProgramadorPhp.add(buttonCadastroProgramadorPhp);

		frameTelaCadastroProgramadorPhp.add(panelTelaCadastroProgramadorPhp);

		frameTelaCadastroProgramadorPhp.setVisible(true);

		TelaCadastroProgramadorPhpController telaCadastroProgramadorPhpController = new TelaCadastroProgramadorPhpController(
				nomeTextField, emailTextField, phpTextField, txtSalarioProgramadorPhp, repositorioProgramadorPhp,
				frameMenuInicialProgramadorPhp, frameTelaCadastroProgramadorPhp);

		buttonCadastroProgramadorPhp.addActionListener(telaCadastroProgramadorPhpController);

	}
}
