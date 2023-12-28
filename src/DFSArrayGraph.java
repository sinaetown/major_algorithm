import java.util.*;

public class DFSArrayGraph {
    static int[][] static_graph;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] graph = { //01324
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        static_graph = graph;
        visited = new boolean[graph.length];
        dfs(0);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.println(start);
        for (int i = 0; i < static_graph[start].length; i++) {
            if (!visited[i] && static_graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
