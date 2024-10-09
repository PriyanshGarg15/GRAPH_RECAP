import java.util.*;

public class a2_putting_weight_also {

    public class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static List<List<Pair>> adjList;

    public a2_putting_weight_also(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(src, weight));
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (Pair pair : adjList.get(i)) {
                System.out.print("(" + pair.node + ", " + pair.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        a2_putting_weight_also a = new a2_putting_weight_also(vertices);
        a.addEdge(0, 1, 2);
        a.addEdge(0, 3, 6);
        a.addEdge(1, 2, 3);
        a.printGraph();
    }
}
