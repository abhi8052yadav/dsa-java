
import java.util.ArrayList;


public class HasCycle {
    static class Edge{
        int src ;
        int dest;
        int wt;
        public Edge(int src, int dest,int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static boolean dfsHasCycle(ArrayList<Edge>[] graph,int curr,boolean[] visit,int par) {
        visit[curr] = true;
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(visit[e.dest] && e.dest != par) return true;
            else if(!visit[e.dest])
            {
                if(dfsHasCycle(graph,e.dest,visit, par)) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
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
        boolean[] visit = new boolean[graph.length];
        System.out.println(dfsHasCycle(graph,0,visit,0));
    }
}
