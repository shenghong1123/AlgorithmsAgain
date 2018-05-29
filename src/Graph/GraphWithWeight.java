package Graph;

import java.util.*;

public class GraphWithWeight {
    List<Integer>[] adj;
    List<Integer>[] cost;

    public GraphWithWeight(int n) {
        adj = new LinkedList[n];
        cost = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
            cost[i] = new LinkedList<>();
        }
    }

    public void addEdge(int x, int y, int w) {
        adj[x - 1].add(y - 1);
        cost[x - 1].add(w);
    }

    /*
    n: number of nodes
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        GraphWithWeight graph = new GraphWithWeight(n);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
        }
    }
}
