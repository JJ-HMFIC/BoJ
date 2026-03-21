
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static int[] distance;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[V + 1];
        Arrays.fill(distance, 1000000);
        int start = Integer.parseInt(br.readLine());
        distance[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }
        dijkstra(start, V);


    }

    private static void dijkstra(int start, int V) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        queue.add(new Node(start, 0));


        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int vertex = now.vertex;

            if (visited[vertex]) continue;
            visited[vertex] = true;

            for (int i = 0; i < list[vertex].size(); i++) {
                Node nextNode = list[vertex].get(i);
                int nextVertex = nextNode.vertex;
                int weight = nextNode.weight;

                if (distance[nextVertex] > distance[vertex] + weight) {
                    distance[nextVertex] = distance[vertex] + weight;
                    queue.add(new Node(nextVertex, distance[nextVertex]));
                }
            }
        }
        sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(visited[i]) sb.append(distance[i]).append("\n");
            else sb.append("INF").append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int end, int weight) {
            this.vertex = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight) return 1;
            else return -1;
        }
    }
}
