import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> graph;
    private int[] td;
    private int[] tt;
    private Integer[] pai;
    private int t;
    private List<Edge> tree = new ArrayList<>();
    private List<Edge> foward = new ArrayList<>();
    private List<Edge> back = new ArrayList<>();
    private List<Edge> cross = new ArrayList<>();
    private int n;

    public Graph(int n) {
        this.graph = new HashMap<>(n);
        this.n = n;
        for (int i = 1; i <= this.n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public int getN() {
        return this.n;
    }

    public List<Integer> getSucessores(int vertice) {
        return graph.get(vertice);
    }

    public List<Integer> getPredecessores(int vertice) {
        List<Integer> lista = new ArrayList<>();

        for (int i = 1; i <= this.n; i++) {
            if (this.graph.get(i).contains(vertice)) {
                lista.add(i);
            }
        }

        return lista;
    }

    public void add(int origem, int destino) {
        graph.get(origem).add(destino);
    }

    public void buscaProfundidade(int target) {
        t = 0;
        td = new int[graph.size() + 1];
        tt = new int[graph.size() + 1];
        pai = new Integer[graph.size() + 1];

        for (int i = 1; i <= n; i++) {
            if (td[i] == 0)
                buscaProfundidade(i, target);
        }
    }

    public void buscaProfundidade(int v, int target){
        t++;
        td[v] = t;
        for (int w : graph.get(v)) {
            Edge e = new Edge(v, w);
            if(td[w] == 0){
                pai[w] = v;
                tree.add(e);
                buscaProfundidade(w, target);
            }else if (v == target) {
                if (tt[w] == 0) {
                    back.add(e);
                } else if (td[v] < tt[w] && v != pai[w]) {
                    foward.add(e);
                } else if (td[v] > tt[w] && v != pai[w]) {
                    cross.add(e);
                }
            }
        }
        t++;
        tt[v] = t;
    }

    public void print() {
        System.out.println("Arestas de Árvore: " + tree.toString().replace("[", "{").replace("]", "}"));
        System.out.println("Arestas de Avanço: " + foward.toString().replace("[", "{").replace("]", "}"));
        System.out.println("Arestas de Cruzamento: " + cross.toString().replace("[", "{").replace("]", "}"));
        System.out.println("Arestas de Retorno: " + back.toString().replace("[", "{").replace("]", "}"));
    }
}
