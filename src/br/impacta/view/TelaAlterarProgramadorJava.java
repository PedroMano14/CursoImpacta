package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorJava;
import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.controller.TelaAlterarProgramadorJavaController;

public class TelaAlterarProgramadorJava {

	public void abrirTelaAlterarProgramadorJava(ProgramadorJava programadorJavaAtual,
			RepositorioProgramadorJava repositorioProgramadorJava, JFrame frameMenuInicialProgramadorJava) {

		String nomeTexto = "Digite o nome do Programador Java:";
		String emailTexto = "Digite o e-mail do Programador Java:";
		String certificacaoOracleTexto = "Digite o certificado Oracle do Programador Java:";

		JFrame frameTelaAlterarProgramadorJava = new JFrame();
		frameTelaAlterarProgramadorJava.setSize(200, 400);
		frameTelaAlterarProgramadorJava.setTitle("Alterar programadores Java");
		frameTelaAlterarProgramadorJava.setLocation(300, 300);

		JPanel panelTelaAlterarProgramadorJava = new JPanel();

		// opcao2
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		panelTelaAlterarProgramadorJava.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(programadorJavaAtual.getNome());
		panelTelaAlterarProgramadorJava.add(nomeTextField);

		// opcao3
		JLabel emailTextLabel = new JLabel(emailTexto);
		panelTelaAlterarProgramadorJava.add(emailTextLabel);

		JTextField emailTextField = new JTextField(10);
		emailTextField.setText(programadorJavaAtual.getEmail());
		panelTelaAlterarProgramadorJava.add(emailTextField);

		JLabel certificacaoOracleTextLabel = new JLabel(certificacaoOracleTexto);
		panelTelaAlterarProgramadorJava.add(certificacaoOracleTextLabel);

		JTextField certificacaoOracleTextField = new JTextField(10);
		certificacaoOracleTextField.setText(programadorJavaAtual.getCertificacaoOracle());
		panelTelaAlterarProgramadorJava.add(certificacaoOracleTextField);

		JLabel lblSalarioProgramadorJava = new JLabel("Digite as horas trabalhadas do programador java");
		panelTelaAlterarProgramadorJava.add(lblSalarioProgramadorJava);

		JTextField txtSalarioProgramadorJava = new JTextField(23);
		txtSalarioProgramadorJava.setText(
				String.valueOf(programadorJavaAtual.calcularHorasTrabalhadas(programadorJavaAtual.getSalario())));
		panelTelaAlterarProgramadorJava.add(txtSalarioProgramadorJava);

		JButton buttonAlterarProgramadorJava = new JButton("Alterar Programador Java");
		panelTelaAlterarProgramadorJava.add(buttonAlterarProgramadorJava);

		frameTelaAlterarProgramadorJava.add(panelTelaAlterarProgramadorJava);

		frameTelaAlterarProgramadorJava.setVisible(true);

		TelaAlterarProgramadorJavaController telaAlterarProgramadorJavaController = new TelaAlterarProgramadorJavaController(
				programadorJavaAtual, nomeTextField, emailTextField, certificacaoOracleTextField,
				txtSalarioProgramadorJava, repositorioProgramadorJava, frameMenuInicialProgramadorJava,
				frameTelaAlterarProgramadorJava);

		buttonAlterarProgramadorJava.addActionListener(telaAlterarProgramadorJavaController);

	}

}
