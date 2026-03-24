import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[][] dist;
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int startX = 0, startY = 0, endX = 0, endY = 0;
        ArrayList<Node> trees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.contains("V")) {
                startX = i;
                startY = line.indexOf("V");
            }
            if (line.contains("J")) {
                endX = i;
                endY = line.indexOf("J");
            }
            map[i] = line.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '+') {
                    trees.add(new Node(i, j));
                }
            }
        }
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        bfs(trees);

        System.out.println(dijkstra(startX, startY, endX, endY));

    }

    private static void bfs(ArrayList<Node> trees) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (Node tree : trees) {
            deque.add(new Node(tree.x, tree.y));
            dist[tree.x][tree.y] = 0;
        }

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                deque.add(new Node(nx, ny));
            }
        }
    }

    private static int dijkstra(int startX, int startY, int endX, int endY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.add(new Node(startX, startY, dist[startX][startY]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            if(cur.x == endX && cur.y== endY) return cur.safety;


            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                int nextSafety = Math.min(cur.safety, dist[nx][ny]);
                pq.add(new Node(nx, ny, nextSafety));


            }

        }
        return 0;
    }



    static class Node implements Comparable<Node> {
        int x,y, safety;

        public Node(int x, int y, int safety) {
            this.x = x;
            this.y = y;
            this.safety = safety;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.safety = 0;
        }

        public int compareTo(Node node) {
            return Integer.compare(node.safety, this.safety);
        }
    }
}
