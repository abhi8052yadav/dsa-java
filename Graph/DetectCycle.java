public class DetectCycle{
  class Edge{
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
  public static boolean detectTheCycle(ArrayList<Edge> graph,int[] visit,int curr,int par)
  {
    visit[curr] = true;
    for(int i=0; i<graph[curr].length; i++)
    {
        Edge e = graph[curr].get(i);
        if(!visit[e.dest])
        {
            if(detectTheCycle(graph, visit, e.dest, par));
        }
    }
  }
}