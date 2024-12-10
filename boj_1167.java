import java.util.*;
public class boj_1167 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) A[i] = new ArrayList<Edge>(); // 인접 리스트로 초기화
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) break;
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            } // 값 세팅
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);
        int Max = 1; // 거리가 가장 먼 곳의 인덱스 찾기 위함
        // 임의의 노드(1)에서 가장 먼 곳의 노드는
        // 지름의 두 노드 중 하나이다.
        for (int i = 2; i <=N; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1]; // 초기화
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge i : A[now_node]) {
                int e = i.e;
                int value = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node]+ value;
                }
            }
        }
    }
}
class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
