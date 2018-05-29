package Graph;

import java.util.*;

/*
Represent graph as adjacent list
DO NOT modify "adj" field once graph instance is created
 */
public class Graph {

    private List<Integer>[] adj;

    public Graph(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adj[from - 1].add(to - 1);
    }

    public void DFS() {
        boolean[] visited = new boolean[this.adj.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;
            System.out.println(node + 1);
            for (int i = 0; i < adj[node].size(); i++) {
                if (!visited[adj[node].get(i)]) stack.push(adj[node].get(i));
            }
        }
    }

    public void BFS() {
        boolean[] visited = new boolean[this.adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            System.out.println(node + 1);
            for (int i = 0; i < adj[node].size(); i++) {
                if (!visited[adj[node].get(i)]) q.add(adj[node].get(i));
            }
        }
    }

    /*
    Detect if there exists cycle in graph
    There is a cycle in a graph only if there is a "back edge" present in the graph
     */

    public boolean hasCycle() {
        boolean[] visited = new boolean[adj.length];
        boolean[] stack = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (exploreCycle(i, visited, stack)) return true;
        }
        return false;
    }

    private boolean exploreCycle(int x, boolean[] visited, boolean[] stack) {
        if (stack[x]) return true;
        if (visited[x]) return false;
        visited[x] = true;
        stack[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            int node = adj[x].get(i);
            if (exploreCycle(node, visited, stack)) return true;
        }
        stack[x] = false;
        return false;
    }

    /*
    Determine if "from" can reach "to"
     */
    public boolean reach(int from, int to) {
        boolean[] visited = new boolean[this.adj.length];
        return reachExplore(visited, from - 1, to - 1);
    }

    private boolean reachExplore(boolean[] visited, int from, int to) {
        if (from == to) return true;
        visited[from] = true;
        for (int i = 0; i < adj[from].size(); i++) {
            int node = adj[from].get(i);
            if (!visited[node] && reachExplore(visited, adj[from].get(i), to)) return true;
        }
        return false;
    }

    /*
    Find a path connecting "from" and "to"
    Not necessary to be the shorest one due to DFS
     */

    public List<Integer> reachPath(int from, int to) {
        boolean[] visited = new boolean[this.adj.length];
        List<Integer> path = new LinkedList<>();
        reachExplorePath(visited, from - 1, to - 1, path);
        return path;
    }

    private boolean reachExplorePath(boolean[] visited, int from, int to, List<Integer> path) {
        if (from == to) {
            path.add(from);
            return true;
        }
        visited[from] = true;
        path.add(from);
        for (int i = 0; i < adj[from].size(); i++) {
            int node = adj[from].get(i);
            if (!visited[node] && reachExplorePath(visited, adj[from].get(i), to, path)) return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    /*
    CC definition: https://en.wikipedia.org/wiki/Connected_component_(graph_theory)
     */
    public int numberOfConnectedComponents() {
        boolean[] visited = new boolean[this.adj.length];
        int cc = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                ccExplore(visited, i);
                cc++;
            }
        }
        return cc;
    }

    private void ccExplore(boolean[] visited, int x) {
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            int node = adj[x].get(i);
            if (!visited[node]) ccExplore(visited, node);
        }
    }

    /*
    SCC definition: https://en.wikipedia.org/wiki/Strongly_connected_component
     */
    public List<List<Integer>> numberOfStronglyConnectedComponents() {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer>[] inverse = getInverseGraph();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.length];
        for (int i = 0; i < inverse.length; i++) {
            if (!visited[i] && inverse[i].size() != 0) postOrder(inverse, visited, i, stack);
        }
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> scc = new LinkedList<>();
                exploreSCC(node, visited, scc);
                result.add(scc);
            }
        }
        return result;
    }

    private List<Integer>[] getInverseGraph() {
        List<Integer>[] inverse = new LinkedList[adj.length];
        for (int i = 0; i < adj.length; i++) {
            inverse[i] = new LinkedList<>();
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inverse[adj[i].get(j)].add(i);
            }
        }
        return inverse;
    }

    private void postOrder(List<Integer>[] inverse, boolean[] visited, int x, Stack<Integer> stack) {
        visited[x] = true;
        for (int i = 0; i < inverse[x].size(); i++) {
            int node = inverse[x].get(i);
            if (!visited[node]) postOrder(inverse, visited, node, stack);
        }
        stack.push(x);
    }

    private void exploreSCC(int x, boolean[] visited, List<Integer> scc) {
        visited[x] = true;
        scc.add(x);
        for (int i = 0; i < adj[x].size(); i++) {
            int node = adj[x].get(i);
            if (!visited[node]) exploreSCC(node, visited, scc);
        }
    }

    /*
    Topological sort for DAG is a linear ordering or vertices such that
    for every directed edge u->v, vertex u comes before v in the ordering.

    Topological sorting for a graph is not possible if the graph is not a DAG
     */

    public List<Integer> topologicalSort() {
        List<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) exploreTS(visited, i, stack);
        }
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private void exploreTS(boolean[] visited, int x, Stack<Integer> stack) {
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            int node = adj[x].get(i);
            if (!visited[node]) exploreTS(visited, node, stack);
        }
        stack.push(x);
    }

    /*
    n: number of nodes
    m: number of edges
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*int n = scanner.nextInt();
        int m = scanner.nextInt();*/
        int n = 6;
        int m = 7;
        Graph graph = new Graph(n);
        /*for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addEdge(x, y);
        }*/
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        //System.out.println(graph.reachPath(1, 6));

        //graph.DFS();

        //graph.BFS();

        /*List<List<Integer>> result = graph.numberOfStronglyConnectedComponents();
        for (List<Integer> list : result) System.out.println(list);*/

        //System.out.println(graph.topologicalSort());

        //System.out.println(graph.hasCycle());

        System.out.println(graph.numberOfConnectedComponents());

    }
}
