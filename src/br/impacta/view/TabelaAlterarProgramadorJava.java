package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorJava;
import br.impacta.repository.RepositorioProgramadorJava;
import br.impacta.view.controller.TabelaAlterarProgramadorJavaController;

public class TabelaAlterarProgramadorJava {

	public void apresentarAlterarProgramadorJava(RepositorioProgramadorJava repositorioProgramadorJava,
			JFrame frameMenuInicialProgramadorJava) {

		int quantidadeDeLinhas = repositorioProgramadorJava.listarProgramadorJava().size();

		String[][] tabelaString = new String[quantidadeDeLinhas][5];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (ProgramadorJava programadorJava : repositorioProgramadorJava.listarProgramadorJava()) {

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getMatricula();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getEmail();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getCertificacaoOracle();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = String.valueOf(programadorJava.getSalario());
			posicaoColuna++;

			posicaoColuna = 0;
			posicaoLinha++;
		}

		String colunasTitulos[] = { "Matricula", "Nome", "Email", "Certificacao Oracle", "Salario" };

		JFrame frameAlterarProgramadorJava = new JFrame();
		frameAlterarProgramadorJava.setSize(500, 600);

		JTable tabelaProgramadorJava = new JTable(tabelaString, colunasTitulos);
		tabelaProgramadorJava.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneAlterarProgramadorJava = new JScrollPane(tabelaProgramadorJava);
		JPanel panelAlterarProgramadorJava = new JPanel();

		JLabel matriculaLabel = new JLabel("Digite a matricula para alterar:");
		panelAlterarProgramadorJava.add(matriculaLabel);

		JTextField matriculaField = new JTextField(10);
		panelAlterarProgramadorJava.add(matriculaField);

		panelAlterarProgramadorJava.add(scrollPaneAlterarProgramadorJava);

		JButton buttonAlterarProgramadorJava = new JButton("Buscar programador java");
		panelAlterarProgramadorJava.add(buttonAlterarProgramadorJava);

		frameAlterarProgramadorJava.add(panelAlterarProgramadorJava);
		frameAlterarProgramadorJava.setVisible(true);

		TabelaAlterarProgramadorJavaController telaAlterarProgramadorJavaController = new TabelaAlterarProgramadorJavaController(
				repositorioProgramadorJava, frameMenuInicialProgramadorJava, frameAlterarProgramadorJava,
				matriculaField);
		buttonAlterarProgramadorJava.addActionListener(telaAlterarProgramadorJavaController);
	}

}
