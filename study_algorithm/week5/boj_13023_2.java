package study_algorithm.week5;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_13023_2 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if(result) break;
        }
        if(result) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(int start, int depth) {
        if(depth==5) {
            result = true;
            return;
        }

        visited[start] = true;

        for (int tmp : graph[start]) {
            if (!visited[tmp]) {
                DFS(tmp, depth + 1);
            }
        }
        visited[start] = false;
        // 잘못 길을 들었을 경우 초기화해서 다시 찾아야 함
        // 틀린 이유
    }
}
