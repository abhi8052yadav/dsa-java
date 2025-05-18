import java.util.*;

public class BellmanFord {
    public static class Edge{
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
    public static void bellmanFord(ArrayList<Edge>[] graph,int src)
    {
        int[] dist = new int[graph.length];
        for(int i=0; i<dist.length; i++)
        {
            if(i != 0)
            {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<dist.length - 1; i++)
        {
            for(int j=0;j<graph.length; j++)
            {
                for(Edge e : graph[j])
                {
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.dest] > dist[e.src]+e.wt){
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++)
        {
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entert the no. of vertices : ");
        int v = sc.nextInt();
        System.out.println("enter the no. of edges : ");
        int e = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            System.out.println("enter the source : ");
            int src = sc.nextInt();
            System.out.println("enter the destination : ");
            int dest = sc.nextInt();
            System.out.println("enter the weight : ");
            int wt = sc.nextInt();

            graph[src].add(new Edge(src,dest,wt));
        }

        bellmanFord(graph,0);
    }
}
