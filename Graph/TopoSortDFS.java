import java.util.*;


public class TopoSortDFS {
    public static class Edge{
        int src;
        int dest;
        public Edge(){}
        public Edge(int src,int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void topoSort(ArrayList<Edge>[] graph,int curr,boolean visit[],Stack<Integer> st)
    {
        visit[curr] = true;
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest])
            {
                topoSort(graph, e.dest, visit, st);
            }
        }
        st.push(curr);
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

            graph[src].add(new Edge(src,dest));
        }
        boolean[] visit = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<v; i++)
        {
            if(!visit[i])
            {
                topoSort(graph,i,visit,st);
            }
        }
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+",");
        }
    }
}
