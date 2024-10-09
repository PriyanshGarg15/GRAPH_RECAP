import java.util.*;
public class a1_using_adj_list {
    private static List<List<Integer>> adjList;
    public a1_using_adj_list(int vertices)
    {
        adjList=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++)
        {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); 
    }

    public static void main(String[] args) {
       a1_using_adj_list pg=new a1_using_adj_list(2);
        pg.addEdge(0, 1);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (int neighbor :adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
