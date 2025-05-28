package kb_algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_14442 {
    static int[][] map;

    static class Pos {
        int x;
        int y;
        int dist;
        int broken;

        public Pos(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDist() {
            return dist;
        }

        public int getBroken() {
            return broken;
        }
    }

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j - 1));
            }
        }
        int result = BFS(1, 1);
        System.out.println(result);
    }

    static public int BFS(int x, int y) {
        Deque<Pos> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][K + 1];
        visited[x][y][0] = true;
        queue.offer(new Pos(x, y, 1, 0));

        while (!queue.isEmpty()) {
            Pos top = queue.poll();
            int topX = top.getX();
            int topY = top.getY();
            int dist = top.getDist();
            int broken = top.getBroken();

            if (topX == N && topY == M) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = topX + dx[i];
                int ny = topY + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
//                if (visited[nx][ny][broken]) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    queue.offer(new Pos(nx, ny, dist + 1, broken));
                }// broken = k면 여기 분기에서 걸림 => 차원을 안바꾸니깐
                if (map[nx][ny] == 1 &&broken<K &&!visited[nx][ny][broken + 1]) {
                    visited[nx][ny][broken + 1] = true;
                    queue.offer(new Pos(nx, ny, dist + 1, broken + 1));
                }
            }

        }
        return -1;
    }
}
