package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class pro_miro {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {

        char[][] grid = new char[maps.length][maps[0].length()];
        int startX = 0;
        int startY = 0;  // 첫 좌표 초기화 (x,y)

        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains("S")) { // S가 있으면
                startX = i; // x 좌표
                startY = maps[i].indexOf('S'); // y 좌표
            }
            grid[i] = maps[i].toCharArray();
        } // String 배열 -> char 2차원 배열로 만들기(grid)

        Search toLever = BFS(grid, startX, startY, 'L');
        if (toLever.getDistance() == -1) return -1; // 처음 S(시작)에서 L(레버)까지 거리 구하기

        Search toGoal = BFS(grid, toLever.getX(), toLever.getY(), 'E');
        if (toGoal.getDistance() == -1) return -1; // L(레버)에서 E(출구)까지 거리 구하기

        return toLever.getDistance() + toGoal.getDistance(); // 두개 더해라
    }

    public Search BFS(char[][] grid, int i, int j, char end) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // visited가 메서드 안에 있는 이유
        // 두 번(재활용)사용해야 하기 때문에 매 번 초기화 해야 함
        Queue<Search> queue = new LinkedList<>();

        queue.offer(new Search(i, j, 0));
        visited[i][j] = true; // 처음 좌표 넣고 방문 처리

        while (!queue.isEmpty()) {
            Search top = queue.poll();

            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (grid[x][y] == end) {
                return new Search(x, y, dist);
            } // 목표 좌표에 도착하면 리턴ㄴ

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                // 예외 처리

                if (grid[nx][ny] != 'X' && !visited[nx][ny]) {
                    // 방문 안했고 벽이 아니면
                    queue.offer(new Search(nx, ny, dist + 1));
                    visited[nx][ny] = true; // 큐에 넣고 방문 처리
                }
            }
        }

        return new Search(-1, -1, -1); // 없으면 -1 리턴
    }
}

class Search { // 좌표 및 거리 클래스
    int x;
    int y;
    int distance;

    public Search(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}
