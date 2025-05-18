import java.util.*;
public class HasPath {
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
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visit)
    {
        if(src == dest) return true;
        visit[src] = true;
        for(int i=0; i<graph[src].size(); i++)
        {
            Edge e = graph[src].get(i);
            if(!visit[e.dest] && hasPath(graph, e.dest, dest, visit))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length;i++)
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
        boolean[] visit = new boolean[v];
        System.out.println(hasPath(graph, 0, 3,visit));
    }
}
