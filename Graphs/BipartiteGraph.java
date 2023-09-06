import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    /*
     * -1 no color
     * 0- 1st color
     * 1- 2nd color
     * O(V+E)
     * acyclic, even - bipartite
     * odd = non bipartite
     */
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

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));

        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextCol = (color[curr] == 0) ? 1 : 10;
                            color[e.dest] = nextCol;
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
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        // 2's neighbor
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }

}
