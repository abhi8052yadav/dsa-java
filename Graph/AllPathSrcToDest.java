import java.util.*;

public class AllPathSrcToDest{
    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void findAllPaths(ArrayList<Edge>[] graph,int source,int destination ,String path)
    {
        if(source == destination)
        {
            System.out.println(path+destination);
            return;
        }

        for(int i=0; i<graph[source].size(); i++)
        {
            Edge e = graph[source].get(i);
            findAllPaths(graph, e.dest, destination, path+source);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no. of vertices : ");
        int v = sc.nextInt();
        System.out.println("enter the no. of edges : ");
        int e = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            System.out.println("enter the source : ");
            int src = sc.nextInt();
            System.out.println("enter the destination : ");
            int dest = sc.nextInt();

            graph[src].add(new Edge(src, dest));
        }

        System.out.println("to find all the paths enter the source and the destination.");
        int source = sc.nextInt();
        int destination = sc.nextInt();

        findAllPaths(graph,source,destination,"");
    }
}