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
    static int root, N;
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
            if (num == -1) {
                root = i;
            } else {
                parents[i] = num;

                tree[i].add(num);
                tree[num].add(i);
            }
        } // 입력을 토대로 간선 그래프 만들기

        int M = Integer.parseInt(br.readLine());
        if (M == root) {
            System.out.println(0);
            return;
        } // 구하고자 하는 값이 루트라면 0 리턴

        tree[M].remove(Integer.valueOf(parents[M]));
        tree[parents[M]].remove(Integer.valueOf(M));
        // 간선 끊기

        int result = BFS(root);
        // 노드의 개수 구하기
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
            boolean isLeaf = true; // 리프노드 판별

            for (int next : tree[top]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
//                    if ((long) tree[next].size() == 1) {
//                        count++;
//                    }
                    isLeaf = false;
                    // BFS로 인접노드가 있다 = 자식노드가 있다
                    // 리프 노드가 아니다
                }
            }
            if(isLeaf) count++;
        }
        return count;

    }
}
