import java.util.*;

public class DirectedCycle {
    public static class Edge{
        int src ;
        int dest;
        public Edge(int src, int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean isCycle(ArrayList<Edge>[] graph,int curr,boolean[] stack,boolean[] visit)
    {  
        visit[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(stack[e.dest])
            {
                return true;
            }
            if(!visit[e.dest] && isCycle(graph, e.dest, stack, visit)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of vertices : ");
        int v = sc.nextInt();
        System.out.println("enter the no. of edges are present");
        int e = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++)
        {
            System.out.println("enter the src ");
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src].add(new Edge(src, dest));
        }
        boolean[] visit = new boolean[v];
        boolean[] stack = new boolean[v];

        for(int i=0; i<v; i++)
        {
            if(!visit[i])
            {
                System.out.println(isCycle(graph,i,stack,visit));
            }
        }
        sc.close();
    }
}
