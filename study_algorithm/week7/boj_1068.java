package study_algorithm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_1068 {
    static int[] parents;
    static int root,N;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num==-1) root = i;
            parents[i] = num;

            tree[i].add(num);
            tree[num].add(i);
        }

        int M = Integer.parseInt(br.readLine());
        tree[M].remove(Integer.valueOf(parents[M]));
        tree[parents[M]].remove(Integer.valueOf(M));

        int result = BFS(root);
        System.out.println(result);

    }

    private static int BFS(int root) {
        boolean[] visited = new boolean[N];
        Deque<Integer> queue = new ArrayDeque<>();
        visited[root] = true;
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int next : tree[top]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    if ((long) tree[next].size() == 1) {
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
