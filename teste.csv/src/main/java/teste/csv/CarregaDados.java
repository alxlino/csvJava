package teste.csv;

public class CarregaDados {

	public static String[] funcional;
	public static String[] senha;
	public static String[] servico;
	public static String[] horas;
	public static String[] status;
	public static int quantidadeLinhas;
	private static final int colunaCampoFuncional = 0;
	private static final int colunaCampoSenha = 1;
	private static final int colunaCampoServico = 2;
	private static final int colunaCampoHoras = 3;
	private static final int colunaCampoStatus = 4;

	public static void main(String[] args) {
		CarregaDados carregaDados = new CarregaDados();
		carregaDados.iniciaCarregaDados();
		System.exit(0); // ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2
						// JDWP exit error AGENT_ERROR_NO_JNI_ENV(183): [util.c:840]
	}

	public void iniciaCarregaDados() {

		CarregaCSV carregaCSV = new CarregaCSV();

		String matriz[][] = carregaCSV.leituraCSV();

		quantidadeLinhas = matriz.length;

		funcional = new String[quantidadeLinhas];
		funcional = carregaCampos(quantidadeLinhas, colunaCampoFuncional, matriz);

		senha = new String[quantidadeLinhas];
		senha = carregaCampos(quantidadeLinhas, colunaCampoSenha, matriz);

		servico = new String[quantidadeLinhas];
		servico = carregaCampos(quantidadeLinhas, colunaCampoServico, matriz);

		horas = new String[quantidadeLinhas];
		horas = carregaCampos(quantidadeLinhas, colunaCampoHoras, matriz);

		status = new String[quantidadeLinhas];
		status = carregaCampos(quantidadeLinhas, colunaCampoStatus, matriz);
	}

	private String[] carregaCampos(int linhas, int coluna, String[][] matriz) {

		String[] camposCSV = new String[linhas];

		for (int i = 0; i < linhas; i++) {

			camposCSV[i] = matriz[i][coluna];

			System.out.println(camposCSV[i]);

		}

		return camposCSV;
	}

}
