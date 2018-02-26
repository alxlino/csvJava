package tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import teste.csv.CarregaDados;

public class WriterTest {
	
	private static BufferedWriter bw = null;

	private static String FILENAME = "D:\\ALEXANDRE\\DOCUMENTOS\\Pasta1.csv";

	public static void main(String[] args) throws IOException {
		
		gravarCSV();

	}

	public static void gravarCSV() {
		try  {
			
			bw = new BufferedWriter(new FileWriter(FILENAME));
			
//			for (String element : CarregaDados.arrayAtualizado) {
//				bw.write(element);
//				bw.write("\n");
//			}
			
			for (int i = 0; i < CarregaDados.arrayAtualizado.length; i++) {
				bw.write(CarregaDados.arrayAtualizado[i]);
				bw.write("\n");
			}
			
			bw.flush();
			bw.close();

			System.out.println("Gravado");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	
}
