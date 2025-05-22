package study_algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1916 {
    static ArrayList<Info>[] map;
    static int[] distance;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 0; i < N+1; i++) {
            map[i] = new ArrayList<>();
        }
        distance = new int[N + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        // 여기까지 초기화

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start].add(new Info(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());
        //----------------입력------------------------------
        int result = dijkstra(startPoint, endPoint);
        System.out.println(result);
        System.out.println();
//        Arrays.stream(distance).forEach(System.out::println);

    }

    private static int dijkstra(int startPoint, int endPoint) {
        PriorityQueue<Info> queue = new PriorityQueue<>();

        queue.add(new Info(startPoint, 0));
        distance[startPoint] = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int now = info.getNow();
//            int weight = info.getWeight();

            if (!visited[now]) {
                visited[now] = true;

                for (Info next : map[now]) {
                    int weight = next.getWeight();

                    if (!visited[next.getNow()] && distance[next.getNow()] > distance[now] + weight) {
                        distance[next.getNow()] = distance[now] + weight;
                        queue.add(new Info(next.getNow(), distance[next.getNow()]));
                    }
                }
            }
        }
        return distance[endPoint];
    }
}

class Info implements Comparable<Info>{
    int now;

    int weight;

    public Info(int now, int weight) {
        this.now = now;
        this.weight = weight;
    }

    public int getNow() {
        return now;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Info i) {
        return this.getWeight() - i.getWeight();
    }
}
