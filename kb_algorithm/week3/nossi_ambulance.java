package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class nossi_ambulance {
    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1}; // 8방향 좌표
    static int m;
    static int n;

    static boolean[][] visited;

    public int solution(int[][] city) {
        m = city.length; // 가로
        n = city[0].length; // 세로

        visited = new boolean[m][n];

        if (city[0][0] == 1 || city[m - 1][n - 1] == 1) return -1;
        // 예외 처리 , 시작점이 막혀있거나, 도착점이 막혀있으면 의미 없음
        // 얼리 리턴

        return BFS(city, 0, 0); // 첫 좌표부터 bfs 돌려서 목적지까지 거리 구하기
    }

    public int BFS(int[][] city, int i, int j) {
        Queue<Move> queue = new LinkedList<>();

        queue.offer(new Move(i, j, 1));
        // 첫 거리부터 1로 설정 => 문제 요구사항
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Move top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (x == m - 1 && y == n - 1) return dist; // 도착점이면 거리 리턴

            for (int k = 0; k < 8; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k]; // 8방향 탐색

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 예외처리

                if (city[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new Move(nx, ny, dist + 1));
                    visited[nx][ny] = true; // 좌표가 문제없이 도로면 방문체크 및 큐에 넣기
                }
            }
        }
        return -1;
    }
}

class Move { // 좌표 및 거리 클래스
    int x;
    int y;
    int distance;

    public Move(int x, int y, int distance) {
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
