package study_algorithm.week5;

import java.util.*;

public class boj_1260_2 {
    static boolean[] visited ;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        } // 인접 리스트 배열 생성
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1]; // 다시 초기화
        BFS(start);

    }

    private static void DFS(int start) {
        System.out.print(start + " "); // 현재 위치 출력
        visited[start] = true; // 방문처리

        for (int i : list[start]) {
            if (!visited[i]) { // 인접노드가 방문안했다면
                DFS(i); // 재귀로 처음 인접 노드를 타고 들어가기
            }
        }
    }

    private static void BFS(int start) {
        Deque<Integer> queue = new LinkedList<>();

        queue.offer(start); // 처음 노드 큐에 넣기
        System.out.print(start + " ");
        visited[start] = true; // 방문처리

        while (!queue.isEmpty()) {
            int now = queue.pop();

            for (int next : list[now]) {
                if (!visited[next]) { // 인접 노드 방문 안했으면
                    queue.offer(next); // 큐에 넣고
                    visited[next] = true; // 방문처리
                    System.out.print(next + " ");
                }
            }
        }
    }
}
