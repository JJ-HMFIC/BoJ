package kb_algorithm.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class pro_divide_two {
    static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        LinkedList<Integer> result = new LinkedList<>();

        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph[a].remove((Integer) b);
            graph[b].remove((Integer) a);

            int count = BFS(n, a);
            result.add(count);

            graph[a].add(b);
            graph[b].add(a);
        }


        int answer = n;

        for (int x : result) {
            answer = Math.min(answer, Math.abs((n - x) - x));
        }
        return answer;
    }

    private int BFS(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int tmp : graph[now]) {
                if (!visited[tmp]) {
                    queue.add(tmp);
                    count++;
                    visited[tmp] = true;
                }
            }
        }
        return count;
    }

}
