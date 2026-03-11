import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] list;//인접 리스트
    static int[] indegree,result; // 각 정점의 진입 차수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[N + 1];
        indegree = new int[N + 1];
        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] building = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            building[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int from = Integer.parseInt(st.nextToken());
                if (from == -1) break;
                list[from].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
                result[i] = building[i];
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                result[next] = Math.max(result[next], result[now] + building[next]);
                indegree[next]--;
                if(indegree[next]==0) queue.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
