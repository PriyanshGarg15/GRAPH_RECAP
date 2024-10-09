import java.util.*;

public class a4_dfs_without_stack {
    public static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private ArrayList<ArrayList<Pair>> adjList;
    private boolean[] visited;

    public a4_dfs_without_stack(int vertices) {
        adjList = new ArrayList<>();
        visited = new boolean[vertices + 1]; // +1 to accommodate 1-based indexing
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>()); 
        }
    }


    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Pair(destination, weight));
        adjList.get(destination).add(new Pair(source, weight));
    }

    // DFS method using recursion
    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (Pair neighbor : adjList.get(vertex)) {
            if (!visited[neighbor.node]) {
                dfs(neighbor.node); // Recursive call for the neighbor
            }
        }
    }

    public void dfsAllComponents() {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("Component starting from vertex " + i + ":");
                dfs(i);
                System.out.println(); 
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6; 
        a4_dfs_without_stack graph = new a4_dfs_without_stack(vertices);
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(3, 5, 0);
        graph.addEdge(5, 4, 0);
        graph.addEdge(4, 2, 0);
        graph.addEdge(6, 6, 0); // Example: A self-loop or disconnected component

        System.out.println("Depth First Search for all components:");
        graph.dfsAllComponents();
    }
}
