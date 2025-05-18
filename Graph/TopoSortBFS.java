import java.util.*;

public class TopoSortBFS {
    static class Edge {
        int src;
        int dest;

        public Edge() {}

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topoSort(ArrayList<Edge>[] graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoOrder = new ArrayList<>();

        // Add all vertices with indegree 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int curr = q.remove();
            topoOrder.add(curr);

            for (Edge e : graph[curr]) {
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // Check if topological sort is possible
        if (topoOrder.size() != graph.length) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.print("Topological Sort (BFS): ");
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
            System.out.println();
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

            graph[src].add(new Edge(src, dest));
        }

        // Build indegree array
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (Edge edge : graph[i]) {
                indegree[edge.dest]++;
            }
        }

        // Perform topological sort
        topoSort(graph, indegree);

        sc.close();
    }
}
