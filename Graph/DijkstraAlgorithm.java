import java.util.*;

public class DijkstraAlgorithm {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge() {}

        public Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair>
    {
        int n; 
        int path;
        public Pair(int n, int path)
        {
            this.n = n; 
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.path - p2.path;
        }
    }
    public static void dijkstraAlgorithm(ArrayList<Edge>[] graph,int src,boolean[] visit)
    {
        int[] distance = new int[graph.length];
        for(int i=0; i<distance.length; i++)
        {
            if(i!=src)
            {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!visit[curr.n]){
                for(Edge e : graph[curr.n])
                {
                    if(distance[e.dest] > distance[e.src]+e.wt){
                        distance[e.dest] = distance[e.src]+e.wt;
                        pq.add(new Pair(e.dest,distance[e.dest]));
                    }
                }
            }
        }
        for(int i=0; i<distance.length; i++)
        {
            System.out.print(distance[i]+",");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            System.out.println("Enter edge " + (i + 1));

            System.out.print("Source: ");
            int src = sc.nextInt();

            System.out.print("Destination: ");
            int dest = sc.nextInt();

            System.out.println("entert the weight of the edge : ");
            int wt = sc.nextInt();

            graph[src].add(new Edge(src, dest,wt));
        }
        boolean visit[] = new boolean[v];
        dijkstraAlgorithm(graph,0,visit);

        sc.close();
    }
}
