package study_algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11437 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[par].add(child);
            tree[child].add(par);
        }
        BFS(1, 0);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = LCA(a, b);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int start, int level) {
        Deque<Info> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        visited[start] = true;
        depth[start] = level;
        queue.add(new Info(start, level));

        while (!queue.isEmpty()) {
            Info top = queue.poll();
            int edge = top.edge;
            int tlevel = top.level;

            for (int next : tree[edge]) {
                if (!visited[next]) {
                    depth[next] = tlevel + 1;
                    visited[next] = true;
                    parent[next] = edge;
                    queue.add(new Info(next, tlevel + 1));
                }
            }
        }

    }

    private static int LCA(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;

    }

    static class Info {
        int edge;
        int level;

        public Info(int edge, int level) {
            this.edge = edge;
            this.level = level;
        }
    }

}
