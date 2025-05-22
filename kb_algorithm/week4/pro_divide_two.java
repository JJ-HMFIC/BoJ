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
        } // 입력

        LinkedList<Integer> result = new LinkedList<>();
        // 자른 후 정점의 개수를 담는 리스트

        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph[a].remove((Integer) b);
            graph[b].remove((Integer) a);
            // 간선을 자르고
            int count = BFS(n, a);
            result.add(count);
            // 자른 후 정점의 개수를 저장
            graph[a].add(b);
            graph[b].add(a);
            // 다시 이어주기
        }


        int answer = n;

        for (int x : result) {
            answer = Math.min(answer, Math.abs((n - x) - x));
        } // 자른 후 정점의 개수 x개, 남은 정점의 개수 n-x개
        // 두 차이 = n- 2x ~ 해당 값의 절대값이 가장 작을 때를 구하기
        return answer;
    }

    private int BFS(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1; // 정점의 개수 세기
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
