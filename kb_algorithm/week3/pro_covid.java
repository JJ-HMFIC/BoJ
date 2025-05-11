package kb_algorithm.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro_covid {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {

        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) { // 스트링 배열 한 개씩
            char[][] grid = new char[5][5]; // 교실 한개

            for (int i = 0; i < 5; i++) {
                grid[i] = place[i].toCharArray();
            } // 스트링 배열의 한 줄(총 5줄)을 char 배열로 찢기
            int result = 1;
            for (int i = 0; i < 5; i++) { // 교실 한개 -> char 2차원 배열로
                for (int j = 0; j < 5; j++) {
                    if (grid[i][j] == 'P') { // P = 응시자, 이 좌표 기준으로 BFS 실행
                        if (BFS(grid, i, j) == 0) { // 거리두기 실패면?
                            result = 0; // 이 교실은 실패했다..
                            break;
                        }
                    }
                }
                if (result == 0) break; // for문을 나오고
            }
            answer.add(result); // 리스트에 추가한다
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
        // 리스트 -> 스트림 -> 배열로 바꾸는 과정 , 리턴에 맞추기
    }

    private int BFS(char[][] grid, int i, int j) {
        Queue<Entry> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5]; // 한 교실 체크 배열

        queue.offer(new Entry(i, j, 0)); // 현재 위치 큐에 삽입
        visited[i][j] = true; // 방문 체크

        while (!queue.isEmpty()) {
            Entry top = queue.poll();
            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (grid[x][y] == 'P' && dist != 0 && dist <= 2) return 0;
            // 조사했는데 응시자 위치 + 거리가 2 이하면 실패함
            // dist != 0 << 처음 큐에서 꺼내면 dist가 0이다
            // 위 조건이 없으면? 항상 0을 반환하게 된다 -> 없어서 한번 틀림
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; // 좌표 예외 처리
                if (visited[nx][ny] || grid[nx][ny] == 'X') continue; // X는 벽, 방문했으면 패스

                queue.offer(new Entry(nx, ny, dist + 1));
                // 위에서 모든 예외를 처리했기에 편하게 큐에 넣고
                visited[nx][ny] = true; // 방문하면 됌
            }
        }
        return 1; // 문제없이 잘 나왔다면 패스
    }

    private class Entry {
        int x;
        int y;
        int distance;

        public Entry(int x, int y, int distance) {
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
}
