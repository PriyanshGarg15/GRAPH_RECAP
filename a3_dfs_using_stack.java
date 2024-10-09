import java.util.*;
public class a3_dfs_using_stack {
    public static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    private ArrayList<ArrayList<Pair>> adjList;

    public a3_dfs_using_stack(int v) {
        adjList = new ArrayList<>();
        for (int i = 0; i <= v; i++) { 
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

    public void DFS(int src, HashSet<Integer> visited) {
        Stack<Integer> s = new Stack<>();
        s.push(src);
        visited.add(src); 

        while (!s.isEmpty()) {
            int rv = s.pop();
            System.out.println(rv);
            List<Pair> neighbors = new ArrayList<>(adjList.get(rv));
            Collections.reverse(neighbors);  

            for (Pair nbr : neighbors) {
                if (!visited.contains(nbr.node)) {
                    s.push(nbr.node);
                    visited.add(nbr.node); 
                }
            }
        }
    }


    public void DFSAllComponents() {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 1; i < adjList.size(); i++) {
            if (!visited.contains(i)) {
                System.out.println("Starting new component from vertex " + i + ":");
                DFS(i, visited);
                System.out.println();  
            }
        }
    }

    public static void main(String[] args) {
        a3_dfs_using_stack g = new a3_dfs_using_stack(6);  
        

        g.AddEdge(1, 2, 0);
        g.AddEdge(1, 3, 0);
        g.AddEdge(3, 5, 0);
        g.AddEdge(5, 4, 0);
        g.AddEdge(4, 2, 0);
        g.AddEdge(6, 6, 0); // Example of a disconnected vertex with a self-loop

  
        g.display();
        

        System.out.println("DFS for all components:");
        g.DFSAllComponents();
    }
}
