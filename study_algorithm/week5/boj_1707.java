package study_algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[V + 1];

            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            int[] color = new int[V + 1];


            for (int j = 0; j < E; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean result = true;

            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) {
                    if (!DFS(graph, color, j, 1)) {
                        result = false;
                        break;
                    }
                }
            }
            System.out.println((result) ? "YES" : "NO");
        }
    }

    private static boolean DFS(ArrayList<Integer>[] graph, int[] color, int start, int paint) {

        color[start] = paint; // 방문하고

        for (int i : graph[start]) {
            if (color[i] == color[start]) return false;
            // 연결된 노드들 중에 같은 색깔이 칠해져 있다 => 이분그래프가 아니다
            if (color[i] == 0) {
                // 연결된 노드 중 방문 안한 노드 가 있다면
                color[i] = paint * (-1);
                // 반대색으로 칠하고
                boolean dfs = DFS(graph, color, i, color[i]);
                // 칠해봤는데 밑단에서
                if (!dfs) return false;
                // 이미 이분그래프가 아니라면 false 리턴을 전달
            }
        }
        return true;
        // 문제없으면 성공
    }
}
