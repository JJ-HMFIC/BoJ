package study_algorithm.week5;

import java.util.*;

public class boj_1260_2 {
    static boolean[] visited ;
    static ArrayList<Integer>[] list;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        sb = new StringBuilder();

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(start);

    }

    private static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i : list[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int start) {
        Deque<Integer> queue = new LinkedList<>();

        queue.offer(start);
        System.out.print(start + " ");
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.pop();

            for (int next : list[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    System.out.print(next + " ");
                }
            }
        }
    }
}
