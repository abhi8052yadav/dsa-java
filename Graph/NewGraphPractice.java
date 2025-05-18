
import java.util.*;


public class NewGraphPractice {
    static class Edge{
        int src;
        int dest;
        int wt; 
        public Edge()
        {}
        public Edge(int src,int dest,int wt )
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[])
    { 
        boolean[] visit = new boolean[graph.length];
        for(int i=0;i<graph.length; i++)
        {
            if(!visit[i])
            {
                dfsTraverse(graph, i, visit);
            }
        }
    }
    public static void dfsTraverse(ArrayList<Edge> graph[],int curr,boolean[] visit)
    {
        visit[curr] = true;
        System.out.print(curr+",");
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest])
            {
                dfsTraverse(graph, e.dest, visit);
            }
        }
        System.out.println();
    }
    public static void bfsTraverse(ArrayList<Edge> graph[])
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visit[curr])
            {
                visit[curr]=true;
                System.out.print(curr+",");
                for(int i=0; i<graph[curr].size();i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean[] visit)
    {
        if(src == dest)
        {
            return true;
        }
        visit[src] = true;
        for(int i=0; i<graph[src].size();i++)
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
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total no. of vertices are present in the graph : ");
        int v = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        for(int i=0; i<v; i++)
        {
            graph[i] = new ArrayList<>();
        }
        System.out.println("enter the no. of edges are present in this graph : ");
        int e = sc.nextInt();
        for(int i=1; i<=e; i++)
        {
            System.out.println("enter the "+i+" edge's src : ");
            int src = sc.nextInt();
            System.out.println("enter the "+i+" edge's dest : ");
            int dest = sc.nextInt();
            System.out.println("enter the "+i+"edge's weight : ");
            int wt = sc.nextInt();

            graph[src].add(new Edge(src,dest,wt));
        }
        boolean[] visit = new boolean[graph.length];

        dfsTraverse(graph,0,visit);
        bfsTraverse(graph);

        boolean[] visited = new boolean[graph.length];
        System.out.println("enter the source from where you want to check, is path exist or not : ");
        int source = sc.nextInt();
        System.out.println("enter the destination where you want to reach by this source : ");
        int destination = sc.nextInt();

        hasPath(graph, source, destination, visited);
    }
}
