package kb_algorithm.week2;

import java.util.*;

public class pro_distant_node {
    static public ArrayList<Integer>[] link; // 리스트 배열
    static boolean[] visited; // 방문했는지 체크 배열
    static int[] distance; // 거리 재는 배열

    public int solution(int n, int[][] edge) {
        link = new ArrayList[n + 1];
        visited = new boolean[n + 1]; // 초기화
        distance = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            link[i] = new ArrayList<>(); // 리스트배열 초기화
        }
        for (int[] e : edge) {
            link[e[0]].add(e[1]);
            link[e[1]].add(e[0]);
        } // 각 노드 연결
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(link[i]);
        } // 리스트 정렬 (각 리스트 안에 리스트를 정렬)

        BFS(1); 
        
        int max_distance = Arrays.stream(distance).max().getAsInt();
        // 가장 먼 거리
        // 메소드 공부하기

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == max_distance) {
                answer++; // 가장 먼거리에 있는 노드 수 카운트
            }
        }

        return answer;
    }

    private void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start); 
        visited[start] = true;
        distance[start] = 0; // 처음 노드 넣기

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 지금 조사하려는 노드

            for (int next : link[node]) { // 연결된 노드를 찾고
                if (!visited[next]) { // 방문 안했으면
                    visited[next] = true; // 방문하고
                    distance[next] = distance[node] + 1;// 거리 +1
                    queue.offer(next); // 큐에 넣어 다음 노드를 찾기
                }
            }
        }
    }
}

