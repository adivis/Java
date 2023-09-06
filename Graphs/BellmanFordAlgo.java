import java.util.ArrayList;

public class BellmanFordAlgo {
    static class Edge {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static void createGraph2(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {// O(V*E)
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // O(v)
        for (int i = 0; i < V - 1; i++) {
            // O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[j].size(); j2++) {
                    Edge e = graph[j].get(j2);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                        dist[v] = dist[u] + wt;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {// O(V*E)
        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(v)
        for (int i = 0; i < V - 1; i++) {
            // O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }

        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        bellmanFord(graph, 0);

        // Second Way
        System.out.println();
        ArrayList<Edge> allEdges = new ArrayList<>();
        createGraph2(allEdges);
        bellmanFord2(allEdges, 0, V);

    }
}
