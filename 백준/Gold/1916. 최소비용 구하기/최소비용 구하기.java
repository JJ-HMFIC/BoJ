
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Node>[] list ;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        dijkstra(start, end, N);
        System.out.println(distance[end]);
    }

    private static void dijkstra(int start, int end, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int vertex = now.vertex;
            if(visited[vertex]) continue;
            visited[vertex] = true;
            
            for (int i = 0; i < list[vertex].size(); i++) {
                Node next = list[vertex].get(i);
                int nvertex = next.vertex;
                int nweight = next.weight;

                if (distance[nvertex] > distance[vertex] + nweight) {
                    distance[nvertex] = distance[vertex] + nweight;
                    pq.add(new Node(nvertex, distance[nvertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int end, int weight) {
            this.vertex = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight >o.weight) return 1;
            else return -1;
        }
    }
}
