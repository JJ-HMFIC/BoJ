package kb_algorithm.week2;

import java.util.*;

public class leet_graph_bipartite {
    //    static ArrayList<Integer>[] adjList;
// graph[u] does not contain u. => 굳이 리스트 배열 안써도됌, 인풋으로 해결 가능
    static int[] color; // 방문 대신 칠하기

    public boolean isBipartite(int[][] graph) {
//        adjList = new ArrayList[graph.length];
        color = new int[graph.length];

        Arrays.fill(color, -1); // 0,1로 채울거임
//        for (int i = 0; i < graph.length; i++) {
//            adjList[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < graph.length; i++) {
//            for (int tmp : graph[i]) {
//                adjList[i].add(tmp);
//                adjList[tmp].add(i);
//            } // 인접 리스트 초기화
//        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1)
                if (!BFS(i, graph)) return false;
        }

        return true;
    }

    private boolean BFS(int start, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int tmp : graph[node]) {

                if (color[tmp] == color[node]) return false;

                if (color[tmp] == -1) {
                    color[tmp] = 1 - color[node];
                    queue.offer(tmp);
                }
            }
        }
        return true;
    }
}
