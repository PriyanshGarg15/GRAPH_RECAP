import java.util.*;

public class a5_no_of_connected_componenets {
    public static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private ArrayList<ArrayList<Pair>> adjList;

    public a5_no_of_connected_componenets(int v) {
        adjList = new ArrayList<>();
        for (int i = 0; i <= v; i++) {  // Initialize with v+1 to handle 1-based indexing
            adjList.add(new ArrayList<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        adjList.get(v1).add(new Pair(v2, cost));
        adjList.get(v2).add(new Pair(v1, cost)); 
    }

    public void display() {
        for (int i = 1; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (Pair p : adjList.get(i)) {
                System.out.print("(" + p.node + ", " + p.weight + ") ");
            }
            System.out.println();
        }
    }

    public void dfs(int vertex, HashSet<Integer> visited, List<Integer> component) {
        visited.add(vertex);
        component.add(vertex); 
        for (Pair neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor.node)) {
                dfs(neighbor.node, visited, component); 
            }
        }
    }

    public void dfsall() {
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> components = new ArrayList<>(); 

        for (int i = 1; i < adjList.size(); i++) {
            if (!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }


        System.out.println("Number of connected components: " + components.size());
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }
    }

    public static void main(String[] args) {
        a5_no_of_connected_componenets g = new a5_no_of_connected_componenets(6);  


        g.AddEdge(1, 2, 0);
        g.AddEdge(1, 3, 0);
        g.AddEdge(3, 5, 0);
        g.AddEdge(5, 4, 0);
        g.AddEdge(4, 2, 0);
        g.AddEdge(6, 6, 0);  // Example of a disconnected vertex with a self-loop

        g.display();
        
        
        g.dfsall();
    }
}
