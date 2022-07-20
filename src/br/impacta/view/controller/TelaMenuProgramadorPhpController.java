package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.TabelaAlterarProgramadorPhp;
import br.impacta.view.TelaCadastroProgramadorPhp;
import br.impacta.view.TelaDeletarProgramadorPhp;
import br.impacta.view.TelaListarProgramadorPhp;

public class TelaMenuProgramadorPhpController implements ActionListener {
	// recebe do construtor
	JFrame frameMenuInicialProgramadorPhp;
	JTextField opcaoMenuProgramadorPhpJTextField;
	TelaCadastroProgramadorPhp telaCadastroProgramadorPhp = new TelaCadastroProgramadorPhp();
	RepositorioProgramadorPhp repositorioProgramadorPhp;
	TelaListarProgramadorPhp telaListarProgramadorPhp = new TelaListarProgramadorPhp();
	TelaDeletarProgramadorPhp telaDeletarProgramadorPhp = new TelaDeletarProgramadorPhp();
	TabelaAlterarProgramadorPhp tabelaAlterarProgramadorPhp = new TabelaAlterarProgramadorPhp();

	public TelaMenuProgramadorPhpController(JFrame frameMenuInicialProgramadorPhp,
			JTextField opcaoMenuProgramadorPhpJTextField, RepositorioProgramadorPhp repositorioProgramadorPhp) {
		super();
		this.frameMenuInicialProgramadorPhp = frameMenuInicialProgramadorPhp;
		this.opcaoMenuProgramadorPhpJTextField = opcaoMenuProgramadorPhpJTextField;
		this.repositorioProgramadorPhp = repositorioProgramadorPhp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (opcaoMenuProgramadorPhpJTextField.getText().equals("1")
				|| opcaoMenuProgramadorPhpJTextField.getText().equals("2")
				|| opcaoMenuProgramadorPhpJTextField.getText().equals("3")
				|| opcaoMenuProgramadorPhpJTextField.getText().equals("4")
				|| opcaoMenuProgramadorPhpJTextField.getText().equals("5")
				|| opcaoMenuProgramadorPhpJTextField.getText().equals("6")) {

			frameMenuInicialProgramadorPhp.setVisible(false);

			switch (opcaoMenuProgramadorPhpJTextField.getText()) {
			case "1":
				telaCadastroProgramadorPhp.abrirTelaCadastroProgramadorPhp(repositorioProgramadorPhp,
						frameMenuInicialProgramadorPhp);
				break;

			case "2":
				telaListarProgramadorPhp.apresentarListaProgramadorPhp(repositorioProgramadorPhp.listarProgramadorPhp(),
						frameMenuInicialProgramadorPhp);
				break;

			case "3":
				telaDeletarProgramadorPhp.apresentarDeletarProgramadorPhp(repositorioProgramadorPhp,
						frameMenuInicialProgramadorPhp);

				break;

			case "4":
				tabelaAlterarProgramadorPhp.apresentarAlterarProgramadorPhp(repositorioProgramadorPhp,
						frameMenuInicialProgramadorPhp);
				break;

			case "5":
				System.out.println("Voltar para o menu inicial");
				break;

			case "6":
				System.out.println("Encerrar");
				break;

			}

		} else {

			JOptionPane.showMessageDialog(null, "Digite uma Opcão Valida!!!");
		}

	}

}
