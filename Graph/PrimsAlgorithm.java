import java.util.*;

public class PrimsAlgorithm {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>
    {
        int v;
        int wt;
        public Pair(int v,int wt )
        {
            this.v = v;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.wt - p2.wt;
        }
    }
    public static void pirmsAlgo(ArrayList<Edge>[] graph)
    {
        boolean[] visit = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!visit[curr.v])
            {
                visit[curr.v] = true;
                finalCost += curr.wt;
                for(Edge e : graph[curr.v])
                {
                    if(!visit[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("the final min cost : "+finalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of vertices : ");
        int v = sc.nextInt();
        System.out.println("enter the no. of edges : ");
        int e = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++)
        {
            System.out.println("enter the src : ");
            int src = sc.nextInt();
            System.out.println("entert the dest : ");
            int dest = sc.nextInt();
            System.out.println("enter the weight : ");
            int wt = sc.nextInt();

            graph[src].add(new Edge(src, dest, wt));
        }


        pirmsAlgo(graph);
    }
}
