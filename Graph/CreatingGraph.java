import java.util.*;

// public class CreatingGraph{
//     static class Edge{
//         int src;
//         int dest;
//         int weight;
//         public Edge(int src,int dest,int weight)
//         {
//             this.src = src;
//             this.dest = dest;
//             this.weight = weight;
//         }
//     }
//     public static void main(String[] args)
//     {
//         System.out.println("enter the no. of vertices : ");
//         int v = 5;
//         ArrayList<Edge>[] graph = new ArrayList[v];
//         for(int i = 0; i<graph.length; i++)
//         {
//             graph[i] = new ArrayList();
//         }
//         graph[0].add(new Edge(0, 1, 5));
//         graph[1].add(new Edge(1, 0, 5));
//         graph[1].add(new Edge(1, 2, 1));
//         graph[1].add(new Edge(1, 3, 3));
//         graph[2].add(new Edge(2, 1, 1));
//         graph[2].add(new Edge(2, 3, 1));
//         graph[2].add(new Edge(2, 4, 2));
//         graph[4].add(new Edge(4, 2, 2));
//         for(int i = 0; i < graph[2].size(); i++)
//         {
//             Edge e = graph[2].get(i);
//             System.out.println(e.dest);
//         }

//     }
// }


public class CreatingGraph{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest, int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void main(String[] args)
    {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[4];
        for(int i = 0; i < v; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,3,1));
        
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,0,1));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,1));

        for(int i = 0; i<graph[2].size(); i++)
        {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}