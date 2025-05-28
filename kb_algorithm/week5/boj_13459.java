package kb_algorithm.week5;

import java.io.*;
import java.util.*;

public class boj_13459 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    static class Location {
        int redX, redY, blueX, blueY, count;

        public Location(int rx, int ry, int bx, int by, int cnt) {
            this.redX = rx;
            this.redY = ry;
            this.blueX = bx;
            this.blueY = by;
            this.count = cnt;
        }
    }

    static class MoveResult {
        int x, y;

        public MoveResult(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    redX = i;
                    redY = j;
                    map[i][j] = '.';
                } else if (c == 'B') {
                    blueX = i;
                    blueY = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = c;
                }
            }
        }

        System.out.println(BFS(new Location(redX, redY, blueX, blueY, 0)));
    }

    private static int BFS(Location start) {
        Queue<Location> queue = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        visited[start.redX][start.redY][start.blueX][start.blueY] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Location top = queue.poll();
            if (top.count > 10) return 0;
            if(map[top.redX][top.redY]=='O') return 1;
            for (int dir = 0; dir < 4; dir++) {
                MoveResult red = move(top.redX, top.redY, dx[dir], dy[dir]);
                MoveResult blue = move(top.blueX, top.blueY, dx[dir], dy[dir]);

                // 파란 구슬이 구멍에 빠지면 실패
                if (map[blue.x][blue.y] == 'O') continue;

                // 빨간 구슬만 빠졌으면 성공
                if (map[red.x][red.y] == 'O') return 1;

                // 위치가 같으면 더 많이 이동한 구슬을 한 칸 뒤로
                if (red.x == blue.x && red.y == blue.y) {
                    int redDist = Math.abs(red.x - top.redX) + Math.abs(red.y - top.redY);
                    int blueDist = Math.abs(blue.x - top.blueX) + Math.abs(blue.y - top.blueY);
                    if (redDist > blueDist) {
                        red.x -= dx[dir];
                        red.y -= dy[dir];
                    } else {
                        blue.x -= dx[dir];
                        blue.y -= dy[dir];
                    }
                }

                if (!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    queue.offer(new Location(red.x, red.y, blue.x, blue.y, top.count + 1));
                }
            }
        }

        return 0;
    }

    private static MoveResult move(int x, int y, int dx, int dy) {
        while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            if (map[x][y] == 'O') break;
        }
        return new MoveResult(x, y);
    }
}
