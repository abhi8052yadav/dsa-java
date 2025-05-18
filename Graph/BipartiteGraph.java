import java.util.*;


public class BipartiteGraph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(){}
        public Edge(int src,int dest,int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static boolean bipartite(ArrayList<Edge>[] graph, int[] color) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < graph.length; i++) { // for disconnected graphs
        if (color[i] == -1) {
            q.add(i);
            color[i] = 0; // Start with color 0
            while (!q.isEmpty()) {
                int curr = q.remove();
                for(Edge e : graph[curr]) {
                    if (color[e.dest] == -1) {
                        color[e.dest] = 1 - color[curr]; // Alternate color
                        q.add(e.dest);
                    } else if (color[e.dest] == color[curr]) {
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of vetrices : ");
        int v = sc.nextInt();
        System.out.println("enter the no. of edges are present : ");
        int e = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        for(int i=0; i<v; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++)
        {
            System.out.println("src :");
            int src = sc.nextInt();
            System.out.println("dest :");
            int dest = sc.nextInt();
            System.out.println("wt :");
            int wt = sc.nextInt();
            graph[src].add(new Edge(src,dest,wt));
        }
        int[] color = new int[graph.length];
        for(int i=0; i<color.length; i++)
        {
            color[i] = -1;
        }
       System.out.println(bipartite(graph,color));
    }
}
