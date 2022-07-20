package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.controller.TelaAlterarProgramadorPhpController;

public class TelaAlterarProgramadorPhp {

	public void abrirTelaAlterarProgramadorPhp(ProgramadorPhp programadorPhpAtual,
			RepositorioProgramadorPhp repositorioProgramadorPhp, JFrame frameMenuInicialProgramadorPhp) {

		String nomeTexto = "Digite o nome do Programador Php:";
		String emailTexto = "Digite o e-mail do Programador Php:";
		String phpTexto = "Digite o nível de PHP do Programador Php:";

		JFrame frameTelaAlterarProgramadorPhp = new JFrame();
		frameTelaAlterarProgramadorPhp.setSize(200, 400);
		frameTelaAlterarProgramadorPhp.setTitle("Alterar programadores Php");
		frameTelaAlterarProgramadorPhp.setLocation(300, 300);

		JPanel panelTelaAlterarProgramadorPhp = new JPanel();

		// opcao2
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		panelTelaAlterarProgramadorPhp.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(programadorPhpAtual.getNome());
		panelTelaAlterarProgramadorPhp.add(nomeTextField);

		// opcao3
		JLabel emailTextLabel = new JLabel(emailTexto);
		panelTelaAlterarProgramadorPhp.add(emailTextLabel);

		JTextField emailTextField = new JTextField(10);
		emailTextField.setText(programadorPhpAtual.getEmail());
		panelTelaAlterarProgramadorPhp.add(emailTextField);

		JLabel lblSalarioProgramadorPhp = new JLabel("Digite as horas trabalhadas do programador Php");
		panelTelaAlterarProgramadorPhp.add(lblSalarioProgramadorPhp);

		JTextField txtSalarioProgramadorPhp = new JTextField(23);
		txtSalarioProgramadorPhp.setText(
				String.valueOf(programadorPhpAtual.calcularHorasTrabalhadas(programadorPhpAtual.getSalario())));
		panelTelaAlterarProgramadorPhp.add(txtSalarioProgramadorPhp);

		JLabel phpTextLabel = new JLabel(phpTexto);
		panelTelaAlterarProgramadorPhp.add(phpTextLabel);

		JTextField phpTextField = new JTextField(10);
		phpTextField.setText(programadorPhpAtual.getPhp());
		panelTelaAlterarProgramadorPhp.add(phpTextField);

		JButton buttonAlterarProgramadorPhp = new JButton("Alterar Programador Php");
		panelTelaAlterarProgramadorPhp.add(buttonAlterarProgramadorPhp);

		frameTelaAlterarProgramadorPhp.add(panelTelaAlterarProgramadorPhp);

		frameTelaAlterarProgramadorPhp.setVisible(true);

		TelaAlterarProgramadorPhpController telaAlterarProgramadorPhpController = new TelaAlterarProgramadorPhpController(
				programadorPhpAtual, nomeTextField, emailTextField, txtSalarioProgramadorPhp, phpTextField,
				repositorioProgramadorPhp, frameMenuInicialProgramadorPhp, frameTelaAlterarProgramadorPhp);

		buttonAlterarProgramadorPhp.addActionListener(telaAlterarProgramadorPhpController);

	}

}
