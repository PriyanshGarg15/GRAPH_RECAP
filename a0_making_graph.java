public class a0_making_graph
{
    private static int[][] adjmatrix;

    public a0_making_graph  (int vertices)
    {
        adjmatrix=new int[vertices][vertices];
    }

    public void addEdge(int source,int destination)
    {
        adjmatrix[source][destination]=1;
        adjmatrix[destination][source]=1;
    }

    public void printMatrix()
    {
        for(int i=0;i<adjmatrix.length;i++)
        {
            for(int j=0;j<adjmatrix.length;j++)
            {
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        a0_making_graph pg=new a0_making_graph(2);
        pg.addEdge(0, 1);
        pg.printMatrix();
    }
}