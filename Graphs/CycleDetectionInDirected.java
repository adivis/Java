import java.util.ArrayList;

public class CycleDetectionInDirected {
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

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 0, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 1));

    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, i, vis, stack))
                    return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[],
            boolean stack[]) {// O(v+e)

        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {
                return true;

            }
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, e.dest, visited, stack))
                    return true;
            }

        }
        stack[curr] = false;

        return false;

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        // 2's neighbor
        createGraph(graph);
        System.err.println(detectCycle(graph));
    }
}
