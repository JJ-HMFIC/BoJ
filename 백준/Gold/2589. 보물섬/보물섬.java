
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
//    static boolean[][] visited;
    static int answer, L, W;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[L][W];
//        visited = new boolean[L][W];
        answer = 0;
        for (int i = 0; i < L; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }

        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        boolean[][] visited = new boolean[L][W];
        Deque<Info> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new Info(x, y, 0));

        while (!queue.isEmpty()) {
            Info top = queue.poll();
            answer = Math.max(top.dist, answer);
            for (int i = 0; i < 4; i++) {
                int nx = top.x + dx[i];
                int ny = top.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= L || ny >= W ||visited[nx][ny]|| map[nx][ny] == 'W') continue;
                visited[nx][ny] = true;
                queue.offer(new Info(nx, ny, top.dist + 1));
            }
        }
    }

    public static class Info {
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
