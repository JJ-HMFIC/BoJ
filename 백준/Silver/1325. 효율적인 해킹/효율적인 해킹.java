import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            ans[i] = count;
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(ans[i], max);
        }
        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);
        count++;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int next : list[top]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
    }
}
