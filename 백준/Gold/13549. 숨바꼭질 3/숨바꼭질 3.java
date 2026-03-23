import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(dijkstra(N, K));
    }

    private static int dijkstra(int n, int k) {
        boolean[] visited = new boolean[100001];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        pq.add(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == k) return time;

            if (visited[pos]) continue;
            visited[pos] = true;

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                pq.add(new int[]{pos * 2, time});
            }
            if (pos - 1 >= 0 && !visited[cur[0] - 1]) {
                pq.add(new int[]{pos - 1, time + 1});
            }
            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                pq.add(new int[]{pos + 1, time + 1});
            }
        }

        return -1;
    }
}
