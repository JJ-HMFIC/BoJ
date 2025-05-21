package study_algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753 {
    static int V, E, K; // k는 출발노드
    static int[] distance; //  최단 거리 저장 배열 , 시작점에서 각 인덱스까지 최단 거리
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        } // 여기까지 초기화

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        } // 그래프 만들기

        //---------------------------------------
        queue.add(new Edge(K, 0)); // 시작점 K
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int now = current.getVertex(); // 인접 노드

            if(visited[now]) continue; // 방문한 적이 있는 노드면 패스
            visited[now] = true;

            for (int i = 0; i < list[now].size(); i++) {
                Edge tmp = list[now].get(i);
                int next = tmp.getVertex();
                int value = tmp.getValue();

                if (distance[next] > distance[now] + value) {
                    distance[next] = value + distance[now];
                    queue.add(new Edge(next, distance[next]));
                }
            }

            for (int i = 1; i <= V; i++) {
                if (visited[i]) {
                    System.out.println(distance[i]);
                } else {
                    System.out.println("INF");
                }
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    int vertex, value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public int getVertex() {
        return vertex;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.value > e.value) return 1;
        else return -1;
    }
}
