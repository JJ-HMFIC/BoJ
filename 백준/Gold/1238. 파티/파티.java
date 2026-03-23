import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] revList;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        revList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            revList[end].add(new Node(start, weight));
        }

        int[] front = dijkstra(K, list);
        int[] back = dijkstra(K, revList);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, front[i] + back[i]);
        }
        System.out.println(max);


    }

    private static int[] dijkstra(int start, ArrayList<Node>[] map) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.vertex;
            if (visited[curV]) continue;
            visited[curV] = true;

            for (int i = 0; i < map[curV].size(); i++) {
                Node next = map[curV].get(i);
                int nextV = next.vertex;
                int nextW = next.weight;

                if (dist[nextV] > dist[curV] + nextW) {
                    dist[nextV] = dist[curV] + nextW;
                    pq.add(new Node(nextV, dist[curV] + nextW));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.weight, node.weight);
        }
    }
}
