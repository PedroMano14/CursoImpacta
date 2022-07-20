package br.impacta.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.TabelaAlterarProgramadorJava;
import br.impacta.view.TelaCadastroProgramadorJava;
import br.impacta.view.TelaDeletarProgramadorJava;
import br.impacta.view.TelaListarProgramadorJava;

public class TelaMenuProgramadorJavaController implements ActionListener {
	// recebe do construtor
	JFrame frameMenuInicialProgramadorJava;
	JTextField opcaoMenuProgramadorJavaJTextField;
	TelaCadastroProgramadorJava telaCadastroProgramadorJava = new TelaCadastroProgramadorJava();
	RepositorioProgramadorJava repositorioProgramadorJava;
	TelaListarProgramadorJava telaListarProgramadorJava = new TelaListarProgramadorJava();
	TelaDeletarProgramadorJava telaDeletarProgramadorJava = new TelaDeletarProgramadorJava();
	TabelaAlterarProgramadorJava tabelaAlterarProgramadorJava = new TabelaAlterarProgramadorJava();

	public TelaMenuProgramadorJavaController(JFrame frameMenuInicialProgramadorJava,
			JTextField opcaoMenuProgramadorJavaJTextField, RepositorioProgramadorJava repositorioProgramadorJava) {
		super();
		this.frameMenuInicialProgramadorJava = frameMenuInicialProgramadorJava;
		this.opcaoMenuProgramadorJavaJTextField = opcaoMenuProgramadorJavaJTextField;
		this.repositorioProgramadorJava = repositorioProgramadorJava;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (opcaoMenuProgramadorJavaJTextField.getText().equals("1")
				|| opcaoMenuProgramadorJavaJTextField.getText().equals("2")
				|| opcaoMenuProgramadorJavaJTextField.getText().equals("3")
				|| opcaoMenuProgramadorJavaJTextField.getText().equals("4")
				|| opcaoMenuProgramadorJavaJTextField.getText().equals("5")
				|| opcaoMenuProgramadorJavaJTextField.getText().equals("6")) {

			frameMenuInicialProgramadorJava.setVisible(false);

			switch (opcaoMenuProgramadorJavaJTextField.getText()) {
			case "1":
				telaCadastroProgramadorJava.abrirTelaCadastroProgramadorJava(repositorioProgramadorJava,
						frameMenuInicialProgramadorJava);
				break;

			case "2":
				telaListarProgramadorJava.apresentarListaProgramadorJava(
						repositorioProgramadorJava.listarProgramadorJava(), frameMenuInicialProgramadorJava);
				break;

			case "3":
				telaDeletarProgramadorJava.apresentarDeletarProgramadorJava(repositorioProgramadorJava,
						frameMenuInicialProgramadorJava);

				break;

			case "4":
				tabelaAlterarProgramadorJava.apresentarAlterarProgramadorJava(repositorioProgramadorJava,
						frameMenuInicialProgramadorJava);
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
