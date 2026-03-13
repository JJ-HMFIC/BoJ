import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dp = new int[N + 1][2]; // 0은 얼리어답터가 아닐때, 1은 얼리어답터일때
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    static void dfs(int idx) {
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for (int next : list[idx]) {
            if (!visited[next]) {
                dfs(next);

                dp[idx][0] += dp[next][1];
                dp[idx][1] += Math.min(dp[next][1], dp[next][0]);
            }
        }
    }


}
