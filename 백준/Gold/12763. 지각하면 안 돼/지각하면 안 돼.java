import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Info>[] list;
    static int N, T, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Info(end, time, cost));
            list[end].add(new Info(start, time, cost));
        }
        dijkstra(1, N);
    }

    private static void dijkstra(int start, int end) {
        int[][] totalCost = new int[N + 1][T + 1];
        for (int i = 1; i < N + 1; i++) Arrays.fill(totalCost[i], Integer.MAX_VALUE);
        totalCost[start][0] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0, 0));

        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (cur.cost > totalCost[cur.vertex][cur.time]) continue;

            if (cur.vertex == end) {
                minCost = Math.min(cur.cost, minCost);
                continue;
            }

            for (Info next : list[cur.vertex]) {
                int nextTime = cur.time + next.time;
                int nextCost = cur.cost + next.cost;

                if (nextTime <= T && nextCost <= M) {
                    if (totalCost[next.vertex][nextTime] > nextCost) {
                        totalCost[next.vertex][nextTime] = nextCost;
                        pq.add(new Info(next.vertex, nextTime, nextCost));
                    }
                }
            }
        }
        System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
        return;
    }

    static class Info implements Comparable<Info> {
        int vertex;
        int time;
        int cost;

        public Info(int vertex, int time, int cost) {
            this.vertex = vertex;
            this.time = time;
            this.cost = cost;
        }

        public int compareTo(Info info) {
            if (this.time == info.time) return Integer.compare(this.cost, info.cost);
            return Integer.compare(this.time, info.time);
        }
    }
}
