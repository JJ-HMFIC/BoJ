import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] distZombie;
    static int N, M, K, S, p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()); // 이하의 이동으로 이동할 수 있는 모든 도시는 위험한 도시

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); // 안전한 도시
        q = Integer.parseInt(st.nextToken()); // 위험한 도시
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        distZombie = new int[N + 1];
        Arrays.fill(distZombie, -1);
        for (int i = 0; i < K; i++) {
            int zombie = Integer.parseInt(br.readLine());
            distZombie[zombie] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        checkZombie();
        dijkstra(1, N);

    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        long[] cost = new long[N + 1];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (cost[cur.vertex] < cur.cost) continue;

            for (int next : list[cur.vertex]) {
                if (distZombie[next] == 0) continue;
                long fee = 0;
                if (next == end) {
                    fee = 0;
                } else if (distZombie[next] != -1 && distZombie[next] <= S) {
                    fee = q;
                } else {
                    fee = p;
                }
                if (cost[next] > cur.cost + fee) {
                    cost[next] = cur.cost + fee;
                    pq.add(new Info(next, cur.cost + fee));
                }
            }
        }
        System.out.println(cost[end]);
    }

    private static void checkZombie() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < distZombie.length; i++) {
            if (distZombie[i] == 0) deque.add(i);
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            if (distZombie[cur] >= S) continue;

            for (int next : list[cur]) {
                if (distZombie[next] == -1) {
                    distZombie[next] = distZombie[cur] + 1;
                    deque.add(next);
                }
            }
        }
    }

    static class Info implements Comparable<Info> {
        int vertex;
        long cost;

        public Info(int vertex, long cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Info info) {
            return Long.compare(this.cost, info.cost);
        }
    }

}
