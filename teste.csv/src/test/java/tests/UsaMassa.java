package tests;

import teste.csv.CarregaDados;

public class UsaMassa {
	
	public static void main(String[] args) {
		
		UsaMassa massa = new UsaMassa();
		
		massa.usaMassaDados();
		
	}
	
	
	private void usaMassaDados() {
		
		CarregaDados carregaDadosCSV = new CarregaDados();
		carregaDadosCSV.iniciaCarregaDados();
		
		//começar i = 1 pois primeira linha(0) é o nome da coluna
		for (int i = 1; i < CarregaDados.quantidadeLinhas; i++) {
			
			System.out.println(CarregaDados.funcional[i]);
			System.out.println(CarregaDados.senha[i]);
			System.out.println(CarregaDados.servico[i]);
			System.out.println(CarregaDados.horas[i]);
			System.out.println(CarregaDados.status[i]);
			
		}
		
		
		
	}

}
