import java.util.*;
public class BFStraverse {
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
    public static void  bfsTraverse(ArrayList<Edge>[] graph)
    {
        boolean[] visit = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); //0 is the src of the graph;
        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visit[curr])
            {
                System.out.print(curr+" ");
                visit[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of vertices : ");
        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
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

        bfsTraverse(graph);
    }
}
