package tests;

import teste.csv.CarregaDados;

public class UsaMassa {
	
	public static void main(String[] args) {
		
		UsaMassa massa = new UsaMassa();
		
		massa.usaMassaDados();
		
		System.exit(0);
		
	}
	
	
	private void usaMassaDados() {
		
		CarregaDados carregaDadosCSV = new CarregaDados();
		carregaDadosCSV.inicializa();
		String[] arrayAtualizado = new String[CarregaDados.quantidadeLinhas];
		
		//começar i = 1 pois a primeira linha(0) é o nome da coluna
		for (int i = 0; i < CarregaDados.quantidadeLinhas; i++) {
			
			if (i == 0) {
				arrayAtualizado[i] = "funcional;senha;servico;horas;status";
				i++;
			}
			
			System.out.println(CarregaDados.funcional[i] + ";" + CarregaDados.senha[i] + ";" +
								CarregaDados.servico[i] + ";" + CarregaDados.horas[i] + ";" + 
								CarregaDados.status[i]);
			
			arrayAtualizado[i] = CarregaDados.funcional[i] + ";" + CarregaDados.senha[i] + ";" +
								 CarregaDados.servico[i] + ";" + CarregaDados.horas[i] + ";" + 
								 "ATUALIZADO";
		}
		carregaDadosCSV.guardaArrayNovoArquivo(arrayAtualizado);
		carregaDadosCSV.exibeArquivoAtualizado();
	}

}
