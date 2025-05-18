import java.util.*;
public class DisconnectedGraphTraversing {
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
    public static void dfsTraverse(ArrayList<Edge>[] graph)
    {
        boolean[] visit = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visit[i])
            {
                dfsUtilTraverse(graph,i,visit);
            }
        }
    }
    public static void dfsUtilTraverse(ArrayList<Edge>[] graph,int curr,boolean[] visit)
    {
        System.out.print(curr+" ");
        visit[curr] = true;
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest])
            {
                dfsUtilTraverse(graph, e.dest, visit);
            }
        }
    }
    public static void main(String[] args)
    {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++)
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
        dfsTraverse(graph);
    }
}
