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
    } // 빨간, 파란 구슬 그리고 몇 번 기울였는 지 확인하는 클래스

    static class MoveResult {
        int x, y;

        public MoveResult(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // 기울인 후 구슬의 좌표

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
        } // 여기까지 입력

        System.out.println(BFS(new Location(redX, redY, blueX, blueY, 0)));
    }

    private static int BFS(Location start) {
        Queue<Location> queue = new LinkedList<>();
        visited = new boolean[N][M][N][M]; // 빨간구슬 xy 파란구슬 xy 좌표
        visited[start.redX][start.redY][start.blueX][start.blueY] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Location top = queue.poll();
            if (top.count > 10) return 0; // 기울이기 10번 넘었다면 실패

            if(map[top.redX][top.redY]=='O') return 1; // 빨간 구슬이 들어갔으면 성공
            // 여기서 체크하려면 초기 cnt를 0으로 해야함

            for (int dir = 0; dir < 4; dir++) {
                MoveResult red = move(top.redX, top.redY, dx[dir], dy[dir]);
                MoveResult blue = move(top.blueX, top.blueY, dx[dir], dy[dir]);
                // 기울인 결과

                // 파란 구슬이 구멍에 빠지면 실패
                // 동시에 들어가도 실패이기 때문에 겹쳐서 좌표 설정 전에 체크해야 함
                if (map[blue.x][blue.y] == 'O') continue;

                // 빨간 구슬만 빠졌으면 성공
                //if (map[red.x][red.y] == 'O') return 1;
                // 여기서 체크하려면 초반 cnt를 1로 설정해야 하고 위에 체크 조건을 해제해야함

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
            // 벽이나 구멍을 만나기 전까지 좌표 설정
            x += dx;
            y += dy;
            if (map[x][y] == 'O') break; // 만약 구멍에 들어갔다면 즉시 정지
        }
        return new MoveResult(x, y); //기울인 좌표 리턴
    }
}


