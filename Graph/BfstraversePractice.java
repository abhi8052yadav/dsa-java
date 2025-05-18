import java.util.*;

public class BfstraversePractice {
    static class Edge{
        int src ; 
        int dest;
        int wt;
        public Edge(int src, int dest, int wt)
        {
            this.src = src;
            this.dest = dest; 
            this.wt = wt;
        }
    }
    static void bfstra(ArrayList<Edge>[] graph)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visit[curr])
            {
                System.out.println(curr+" ");
                visit[curr] = true;
                for(int i=0; i<graph[curr].size(); i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++)
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

        bfstra(graph);
    }
}
