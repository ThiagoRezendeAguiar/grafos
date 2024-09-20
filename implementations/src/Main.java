import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Main {

	public static Graph createGrafo(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = br.readLine();
			String[] parts = line.split("  ");

			int n = Integer.parseInt(parts[0]);
			// int m = Integer.parseInt(parts[1]);

			Graph grafo = new Graph(n);

			while ((line = br.readLine()) != null) {
				line = line.trim();
				parts = line.split("\\s+");

				int origem = Integer.parseInt(parts[0]);
				int destino = Integer.parseInt(parts[1]);
				grafo.add(origem, destino);
			}
			br.close();
			return grafo;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void searchVertice(int vertice, Graph grafo) {
		List<Integer> listaS = grafo.getSucessores(vertice);
		List<Integer> listaP = grafo.getPredecessores(vertice);
		
		System.out.println("(i) Grau de saída: " + listaS.size());
		System.out.println("(ii) Grau de entrada: " + listaP.size());
		System.out.println("(iii) Conjunto de sucessores: " + listaS.toString().replace("[", "{").replace("]", "}"));
		System.out.println("(iv) Conjunto de predecessores: " + listaP.toString().replace("[", "{").replace("]", "}"));
	}

	//graph-test-50000-1-ordenado.txt
	//graph-test-100-1-ordenado.txt
	//java -Xss8m

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o path do arquivo: ");
		String fileName = in.nextLine();
		Graph grafo = createGrafo(fileName);
		if(grafo != null){
			System.out.println("Digite o vértice: ");
		    int vertice = in.nextInt();
			//searchVertice(vertice, grafo);
			grafo.buscaProfundidade(vertice);
			grafo.print();
		}
		
		
		in.close();
	}
}

