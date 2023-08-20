import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int dest;
        int src;
        int cost;

        public Edge(int d, int s, int c) {
            dest = d;
            src = s;
            cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x])
            return x;

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parb = find(b);

        if (rank[parA] == rank[parb]) {
            par[parb] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parb]) {
            par[parb] = parA;
        } else {
            par[parA] = parb;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            // no cycle
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.cost;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);// O(eloge+V)
    }
}
