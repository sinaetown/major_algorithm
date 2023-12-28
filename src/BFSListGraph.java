import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    //static int[] distance; //한 노드에서 특정 노드가 얼마나 떨어져 있는지!
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
        bfs(0);
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next + " ");
            for (int target : adjList.get(next)) {
                if (!visited[target]) {
                    queue.add(target);
                    visited[target] = true;
                }
            }

        }
    }
}
