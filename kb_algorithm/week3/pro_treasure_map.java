package kb_algorithm.week3;

import java.util.LinkedList;
import java.util.Queue;

public class pro_treasure_map {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dx2 = {0, 0, 2, -2};
    static int[] dy2 = {2, -2, 0, 0}; // 점프할 때 좌표

    public int solution(int n, int m, int[][] hole) {
        int[][] map = new int[n + 1][m + 1];

        for (int[] idx : hole) {
            int x = idx[0];
            int y = idx[1];
            map[x][y] = 1; // 구멍은 1로 표시
        }
        // hole은 좌표만 주어짐 -> 2차원 배열로 전체 지도를 그리기

        int result = BFS(map, n, m);
        return result;
    }

    private int BFS(int[][] map, int n, int m) {
        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        // [0] 점프 안씀 [1] 점프 씀
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(1, 1, 0, false));
        // 일단은 점프를 바로 안쓴다
        visited[1][1][0] = true; //방문하고

        while (!queue.isEmpty()) {
            State top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int time = top.getTime();
            boolean used = top.isUsed(); // 정보 가져오기

            if (x == n && y == m) return time; // 도착점에 다다르면 리턴

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                //일반적인 좌표 꺼내기 및 예외 처리
                if (visited[nx][ny][used ? 1 : 0]) continue;
                // 해당 좌표를 방문했다면? 패스
                if (map[nx][ny] == 1) continue;
                //장애물이면 패스
                visited[nx][ny][used ? 1 : 0] = true;
                //방문처리
                queue.offer(new State(nx, ny, time + 1, used));
                //큐에 넣기
            } // 여기까진 똑같음

            if (!used) { // 만약 2단 점프를 안 썼다면 <진짜 if 가정>
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx2[i];
                    int ny = y + dy2[i];
                    // 점프한 좌표를 계산
                    if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                    //예외 처리
                    if(map[nx][ny] == 1) continue; // 이거 안해서 틀렸음
                    // 점프했는데 그 자리가 장애물이어도 실패
                    if (visited[nx][ny][1]) continue;
                    // 이미 그 자리를 한번 방문했다면 패스
                    visited[nx][ny][1] = true; //방문하고
                    queue.offer(new State(nx, ny, time + 1, true)); //큐에 넣기
                }
            }


        }

        return -1; // 도착못하는 경우
    }
}

class State {
    int x;
    int y;
    int time;
    boolean used; // 점프를 사용했는 지 확인하는 변수

    public State(int x, int y, int time, boolean used) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.used = used;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }

    public boolean isUsed() {
        return used;
    }
}
