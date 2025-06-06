package kb_algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_19238 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 지도 입력
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Entry taxi = new Entry(x, y); // 택시 첫 좌표

        List<Passenger> passengers = new ArrayList<>();// 손님 리스트


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            passengers.add(new Passenger(new Entry(startX, startY), new Entry(endX, endY)));
        } // 손님 시작 ~ 도착지 리스트 만들기

        int result = runSimulation(taxi, map, passengers, N, fuel);
        System.out.println(result);

    }

    private static int BFS(int[][] map, Entry start, Entry end, int N) {
        Queue<Entry> queue = new LinkedList<>();
        visited = new boolean[N + 1][N + 1];

        queue.offer(new Entry(start.getX(), start.getY(), 0));
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Entry top = queue.poll();

            int x = top.getX();
            int y = top.getY();
            int dist = top.getDistance();

            if (x == end.getX() && y == end.getY()) return dist;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 1 || nx >= map.length || ny < 1 || ny >= map[0].length) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.offer(new Entry(nx, ny, dist + 1));
            }
        }
        return -1;
    }

    private static Target findClosestPassenger(Entry taxi, int[][] map, List<Passenger> passengers, int N) {

        visited = new boolean[N + 1][N + 1];
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(taxi.getX(), taxi.getY(), 0)); // 택시의 위치 큐에 넣고
        visited[taxi.getX()][taxi.getY()] = true; // 방문처리

        List<Target> clients = new ArrayList<>(); // 우선순위 리스트
        int minDist = Integer.MAX_VALUE; // 비교하기 위해 가장 큰 값을 일단 넣기
        while (!queue.isEmpty()) {
            Entry top = queue.poll(); // 좌표

            if (top.getDistance() > minDist) break; // 현재 최소 거리 보다 멀면 패스함

            for (int i = 0; i < passengers.size(); i++) {
                Passenger p = passengers.get(i);

                if (top.getX() == p.start.getX() && top.getY() == p.start.getY()) {
                    clients.add(new Target(i, new Entry(top.getX(), top.getY()), top.getDistance()));
                    minDist = top.getDistance();
                }
            }// 택시로부터 bfs로 손님의 위치에 도착 = 손님과 택시까지의 거리 => 그제서야 리스트에 넣기

            for (int i = 0; i < 4; i++) {
                int nx = top.getX() + dx[i];
                int ny = top.getY() + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.offer(new Entry(nx, ny, top.getDistance() + 1)); // 흔한 bfs
            }
        }
        if (clients.isEmpty()) return null;
        // while문 다 돌면 리스트에 거리 순으로 손님 넣었음
        // 동일한 거리일 경우에 우선순위 처리
        clients.sort((a, b) -> {
            if (a.position.getX() != b.position.getX()) return Integer.compare(a.position.getX(), b.position.getX());
            // x 좌표가 작은 것 먼저
            return Integer.compare(a.position.getY(), b.position.getY());
            // x 좌표가 작으면 y좌표가 작은 것 먼저
        });

        return clients.get(0); //가장 가까운 손님의 인덱스 + 좌표 + 도착지 리턴
    }

    private static int runSimulation(Entry taxi, int[][] map, List<Passenger> passengers, int N, int fuel) {
        while (!passengers.isEmpty()) { // 손님 정보 리스트 = passengers
            Target target = findClosestPassenger(taxi, map, passengers, N);
            // 택시 위치에서 가장 가까운 승객 위치 정보 반환
            if (target == null) return -1;

            int dist = target.distance; // 가장 가까운 손님의 거리
            if (fuel < dist) return -1; // 현재 연료로 거기까지 못가면 gg
            fuel -= dist;
//            taxi = target.position; // 택시 위치 업데이트

            Passenger p = passengers.get(target.index);
            // 입력 받았을 때 리스트에서 몇 번째 인덱스의 손님이
            // 제일 가까운가
            // passenger 리스트에 있는 인덱스를 타겟의 멤버변수로 저장해서 가능하다
            int dest = BFS(map, p.start, p.end, N);
            // 제일 가까운 거리의 손님의 출발~도착지 거리 계산
            if (dest == -1 || fuel < dest) return -1; // 안되면 gg
            fuel -= dest;
            fuel += dest * 2;

            taxi = p.end; // 택시에 손님 도착지에 서 있음
            passengers.remove(target.index); // 손님 리스트에서 제거
        }
        return fuel;
    }

}

class Entry { // 좌표
    int x;
    int y;
    int distance;

    public Entry(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

class Passenger { // 출발, 목적지를 위한 클래스
    Entry start;
    Entry end;

    public Passenger(Entry start, Entry end) {
        this.start = start;
        this.end = end;
    }
}

class Target { // 가장 가까운 타겟을 찾는 클래스
    int index;     // passengers 리스트에서의 인덱스
    Entry position;
    int distance;

    public Target(int index, Entry position, int distance) {
        this.index = index;
        this.position = position;
        this.distance = distance;
    }
}

