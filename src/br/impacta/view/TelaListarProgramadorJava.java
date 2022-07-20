package br.impacta.view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.impacta.model.ProgramadorJava;
import br.impacta.view.controller.TelaListarProgramadorJavaController;

public class TelaListarProgramadorJava {

	public void apresentarListaProgramadorJava(List<ProgramadorJava> listaDeProgramadorJavaes,
			JFrame frameMenuInicialProgramadorJava) {

		int quantidadeDeLinhas = listaDeProgramadorJavaes.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][5];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (ProgramadorJava programadorJava : listaDeProgramadorJavaes) {

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getMatricula();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = String.valueOf(programadorJava.getSalario());
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getEmail();
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = programadorJava.getCertificacaoOracle();
			posicaoColuna++;

			posicaoColuna = 0;
			posicaoLinha++;
		}

		String colunasTitulos[] = { "Matricula", "Nome", "Salario", "Email", "Certificacao Oracle" };

		JFrame frameListarProgramadorJava = new JFrame();
		frameListarProgramadorJava.setSize(500, 600);

		JTable tabelaProgramadorJava = new JTable(tabelaString, colunasTitulos);
		tabelaProgramadorJava.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarProgramadorJava = new JScrollPane(tabelaProgramadorJava);
		JPanel panelListarProgramadorJava = new JPanel();

		panelListarProgramadorJava.add(scrollPaneListarProgramadorJava);

		JButton buttonListarProgramadorJava = new JButton("Voltar para Menu ProgramadorJava");
		panelListarProgramadorJava.add(buttonListarProgramadorJava);

		frameListarProgramadorJava.add(panelListarProgramadorJava);
		frameListarProgramadorJava.setVisible(true);

		TelaListarProgramadorJavaController telaListarProgramadorJavaController = new TelaListarProgramadorJavaController(
				frameMenuInicialProgramadorJava, frameListarProgramadorJava);
		buttonListarProgramadorJava.addActionListener(telaListarProgramadorJavaController);
	}
}
