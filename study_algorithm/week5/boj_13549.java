package study_algorithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13549 {
    static int[] dx = {-1, 1};
    // 좌표를 작은거 부터 설정하니까 통과한다
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        if (N == M) {
            System.out.println(0);
            return;
        }

        BFS(N, M);
    }

    private static void BFS(int n, int m) {
        Deque<Info> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        deque.offer(new Info(n, 0));


        while (!deque.isEmpty()) {
            Info now = deque.poll();
            int location = now.getLocation();
            int time = now.getTime();

            visited[location] = true;

            if (location == m) {
                System.out.println(time);
                return;
            }
            int next = location * 2;
            if (next < 100001 && !visited[next]) {
                deque.addFirst(new Info(next, time));
                visited[next] = true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = location + dx[i];
                if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    deque.offer(new Info(nx, time + 1));
                }
            }
        }
    }
}

class Info {
    int location;
    int time;

    public Info(int location, int time) {
        this.location = location;
        this.time = time;
    }

    public int getLocation() {
        return location;
    }

    public int getTime() {
        return time;
    }
}