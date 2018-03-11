package teste.csv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaAplicativo {

	private JFrame janela;
	private JPanel painel;
	private JPanel panLeft = new JPanel(new BorderLayout());
	private JPanel panRigth = new JPanel(new BorderLayout());
	private JPanel panSouth = new JPanel(new BorderLayout());
	private ButtonGroup radioGroup = new ButtonGroup();
	private JRadioButton radioValidaLogin;
	private JRadioButton radioApontamento;
	private String opcaoSelecionada;
	
	public void escolheArquivoCSV(String opcao) throws FileNotFoundException {
		File caminho;
		JFileChooser chooser = new JFileChooser("C:\\Users\\Public\\Documents");
		chooser.setFileFilter(new FileNameExtensionFilter("Apenas .csv", "csv"));
		int retorno = chooser.showOpenDialog(null);
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminho = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(null, "OK!!  | " + caminho.getPath() + " | " + opcao);
		} else if(retorno == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "cancela!");
		}else {
			JOptionPane.showMessageDialog(null, "teste!");
		}
	}

	
	public void constroiTela() {
		
		panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panRigth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panSouth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		
		preparaJanela();
		preparaPainelPrincipal();
		preparaOpcaoValidaLogin();
		preparaOpcaoApontamento();
		preparaGrupoOpcoes();
		preparaBotaoEscolherCSV();
		preparaBotaSair();
		mostraJanela();
		
	}


	private void preparaJanela() {
		janela = new JFrame("Nome da Janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	private void preparaPainelPrincipal() {
		painel = new JPanel(new BorderLayout());
		painel.add(panLeft,BorderLayout.WEST);
		painel.add(panRigth,BorderLayout.EAST);
		painel.add(panSouth,BorderLayout.SOUTH);
		janela.add(painel);
	}
	
	private void preparaGrupoOpcoes() {
		radioGroup.add(radioApontamento);
		radioGroup.add(radioValidaLogin);
	}
	
	private void preparaOpcaoApontamento() {
		radioApontamento = new JRadioButton("Apontamento");
		radioApontamento.setSelected(true);
		radioApontamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcaoSelecionada = "Apontamento"; 
			  }
		});
		//painel.add(radioApontamento, BorderLayout.WEST);
		panRigth.add(radioApontamento);		
	}


	private void preparaOpcaoValidaLogin() {
		radioValidaLogin = new JRadioButton("Validar Login e Senha");
		radioValidaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcaoSelecionada = "LoginSenha"; 
			  }
		});
		//painel.add(radioValidaLogin, BorderLayout.EAST);
		panLeft.add(radioValidaLogin);
	}
	
	private void preparaBotaSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
		});
		panSouth.add(botaoSair, BorderLayout.SOUTH);
	}

	private void preparaBotaoEscolherCSV() {
		JButton botaoSelecionarCSV = new JButton("Carregar CSV");
		botaoSelecionarCSV.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  try {
					escolheArquivoCSV(opcaoSelecionada);
				} catch (FileNotFoundException eFile) {
					eFile.printStackTrace();
				}
			  }
		});
		panSouth.add(botaoSelecionarCSV, BorderLayout.CENTER);
	}
	
	private void mostraJanela() {
		janela.pack();
		janela.setSize(350, 180);
		janela.setVisible(true);
	}

}
