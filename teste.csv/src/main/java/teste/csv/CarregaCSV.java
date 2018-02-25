package teste.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class CarregaCSV {

	private String arquivoCSV = "D:\\ALEXANDRE\\DOCUMENTOS\\Pasta1.csv";
	private BufferedReader conteudoCSV = null;
	private String linha = "";
	private String csvDivisor = ";";
	public static final int numeroColunasCSV = 5;

	public static void main(String[] args) {

		CarregaCSV lerCSV = new CarregaCSV();

		lerCSV.leituraCSV();

	}

	private void pegaCaminhoCSV() {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("massa/Pasta1.csv").getFile());

		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(arquivoCSV);

		arquivoCSV = file.getPath();

		arquivoCSV = arquivoCSV.replace("%20", " ");

		System.out.println(arquivoCSV);

	}

	public String[][] leituraCSV() {

		String[][] apontamentos = null;

		try {

			int qtdeLinhasArquivo = pegaNumTotalLinhasCSV();

			apontamentos = new String[qtdeLinhasArquivo][numeroColunasCSV];
			
			iniciarConteudoCSV();

			int i = 0;
			
			while ((linha = conteudoCSV.readLine()) != null) {

				String[] apontamento = linha.split(csvDivisor);

				for (int j = 0; j < apontamento.length; j++) {

					apontamentos[i][j] = apontamento[j];

					System.out.println(apontamentos[i][j]);
				}

				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return apontamentos;

	}

	private int pegaNumTotalLinhasCSV() throws FileNotFoundException {
		iniciarConteudoCSV();
		Stream<String> linhasCSV = conteudoCSV.lines();
		int qtdeLinhasArquivo = (int) linhasCSV.count();
		return qtdeLinhasArquivo;
	}

	private void iniciarConteudoCSV() throws FileNotFoundException {
		pegaCaminhoCSV();
		conteudoCSV = null;
		conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));
	}
}
