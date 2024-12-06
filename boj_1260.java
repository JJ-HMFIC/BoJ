import java.util.*;

public class boj_1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Start = sc.nextInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]); // List<T>타입의 정렬 방법
        }
        DFS(Start);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(Start);
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            // front 빼내기
            System.out.println(now_Node + " ");
            for (int i : A[now_Node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void DFS(int start) {
        System.out.println(start + " ");
        visited[start] = true;
        for (int i : A[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
