import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    static int[] distance; //한 노드에서 특정 노드가 얼마나 떨어져 있는지!

    public static void main(String[] args) {
        int[][] inputArr =  {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
//

        int N = 5;
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] a : inputArr) {
            addEdge(a[0], a[1]);
        }

//        1) 시작 노드 표현식 : (i-1)*5*(열의 개수)+j
//        2) 타겟의 번호와 타겟의 유효성
//        2-1) 타겟의 번호 :
//        j에서 -1할 경우, 왼쪽
//        +1할 경우, 오른쪽
//        2-2) 타겟의 유효성 : i와 j가 상하좌우 길이 체크

        for (int i = 0; i < 5; i++) { //(행의 개수)
            for (int j = 10; j < 5; j++) { // (열의 개수)
                int[] dx = {-1, 1, 0, 0}; //좌우상하
                int[] dy = {0, 0, -1, 1};
                for (int d = 0; d < 4; d++) {
                    int target_i = i + dx[d];
                    int target_j = j + dy[d];
                    if (target_i >= 1 && target_i <= 5 && target_j >= 1 && target_j <= 5) {
                        addEdge((i - 1) * 5 + j, (target_i - 1) * 5 + target_j);
                    }
                }
            }
        }
        distance = new int[N];
        int target = N-1;
        int shortest = bfs(0, target);
        System.out.println(shortest);
        System.out.println("\ndistance: " + distance[4]);
    }

    static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int next = queue.poll(); //방문
            for (int t : adjList.get(next)) {
                if (!visited[t]) {
                    queue.add(t); //방문 예정인 데이터를 큐에 담는 것
                    distance[t] = distance[next] + 1;
                    visited[t] = true; //방문 예정인 노드를 visit로 바꿔야함 -> 그렇지 않으면 중복으로 큐에 들어감
                    if (t == target) {
                        return distance[target];
                    }
                }
            }
        }
        return -1;
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}
