package questao2;

import java.io.*;


public class Main {

	public static void main(String[] args) {
            
		try (BufferedReader buffer = new BufferedReader(new FileReader("./src/questao2/input.txt"))) {
			String linha = buffer.readLine();
			while (null != linha) {
				Grafo grafo = new Grafo();
				for (String x : linha.split(" ")) {
					int no = Integer.parseInt(x);
					grafo.insere(no);
				}
				for (linha = buffer.readLine(); null != linha && !linha.toUpperCase().equals("FIM"); linha = buffer.readLine()) {
					String[] array = linha.split(" ");
					grafo.insere(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
				}
				System.out.println(grafo.classifica());
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
