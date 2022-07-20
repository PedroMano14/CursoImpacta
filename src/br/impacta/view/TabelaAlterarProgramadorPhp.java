package br.impacta.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.impacta.model.ProgramadorPhp;
import br.impacta.repository.RepositorioProgramadorPhp;
import br.impacta.view.controller.TabelaAlterarProgramadorPhpController;

public class TabelaAlterarProgramadorPhp {

	public void apresentarAlterarProgramadorPhp(RepositorioProgramadorPhp repositorioProgramadorPhp,
			JFrame frameMenuInicialProgramadorPhp) {

		int quantidadeDeLinhas = repositorioProgramadorPhp.listarProgramadorPhp().size();

		String[][] tabelaString = new String[quantidadeDeLinhas][5];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (ProgramadorPhp programadorPhp : repositorioProgramadorPhp.listarProgramadorPhp()) {

			tabelaString[posicaoLinha][posicaoColuna] = programadorPhp.getMatricula();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorPhp.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = String.valueOf(programadorPhp.getSalario());
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = programadorPhp.getEmail();
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = programadorPhp.getPhp();
			posicaoColuna++;

			posicaoColuna = 0;
			posicaoLinha++;
		}

		String colunasTitulos[] = { "Matricula", "Nome", "Salario", "Email" , "Nivel Php"};

		JFrame frameAlterarProgramadorPhp = new JFrame();
		frameAlterarProgramadorPhp.setSize(500, 600);

		JTable tabelaProgramadorPhp = new JTable(tabelaString, colunasTitulos);
		tabelaProgramadorPhp.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneAlterarProgramadorPhp = new JScrollPane(tabelaProgramadorPhp);
		JPanel panelAlterarProgramadorPhp = new JPanel();

		JLabel matriculaLabel = new JLabel("Digite a matricula para alterar:");
		panelAlterarProgramadorPhp.add(matriculaLabel);

		JTextField matriculaField = new JTextField(10);
		panelAlterarProgramadorPhp.add(matriculaField);

		panelAlterarProgramadorPhp.add(scrollPaneAlterarProgramadorPhp);

		JButton buttonAlterarProgramadorPhp = new JButton("Buscar programador Php");
		panelAlterarProgramadorPhp.add(buttonAlterarProgramadorPhp);

		frameAlterarProgramadorPhp.add(panelAlterarProgramadorPhp);
		frameAlterarProgramadorPhp.setVisible(true);

		TabelaAlterarProgramadorPhpController telaAlterarProgramadorPhpControle = new TabelaAlterarProgramadorPhpController(
				repositorioProgramadorPhp, frameMenuInicialProgramadorPhp, frameAlterarProgramadorPhp, matriculaField);
		buttonAlterarProgramadorPhp.addActionListener(telaAlterarProgramadorPhpControle);
	}

}
