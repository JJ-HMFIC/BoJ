import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int K, W, H;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] kx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] ky = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();
        
    }

    private static void bfs() {
        Queue<Info> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.add(new Info(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                System.out.println(now.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny][now.k] || map[nx][ny] == 1) continue;
                queue.add(new Info(nx, ny, now.dist + 1, now.k));
                visited[nx][ny][now.k] = true;
            }
            if (now.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nkx = now.x + kx[i];
                    int nky = now.y + ky[i];
                    if (nkx < 0 || nky < 0 || nkx >= H || nky >= W || visited[nkx][nky][now.k + 1] || map[nkx][nky] == 1)
                        continue;

                    queue.add(new Info(nkx, nky, now.dist + 1, now.k + 1));
                    visited[nkx][nky][now.k + 1] = true;

                }
            }
        }
        System.out.println(-1);
    }

    static class Info {
        int x, y, dist, k;

        public Info(int x, int y, int dist, int k) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.k = k;
        }
    }
}
