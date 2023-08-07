import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTAlgo {
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

        graph[0].add(new Edge(1, 1, 10));
        graph[0].add(new Edge(1, 2, 15));
        graph[0].add(new Edge(1, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        // graph[3].add(new Edge(3,5, 50));

    }

    static class Pair implements Comparable<Pair> {
        int vertex, cost;

        public Pair(int v, int c) {
            vertex = v;
            cost = c;

        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void primsMST(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost = finalCost + curr.cost;

                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        primsMST(graph);

    }
}
