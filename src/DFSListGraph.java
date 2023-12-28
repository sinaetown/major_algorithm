import java.util.*;

public class DFSListGraph {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};

        int N = 5;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] a : inputArr) {
            addEdge(a[0], a[1]);
        }
        dfs(0);
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.println(start);
        for (int target : adjList.get(start)) {
            if (!visited[target]) {
                dfs(target);
            }
        }
    }
}
