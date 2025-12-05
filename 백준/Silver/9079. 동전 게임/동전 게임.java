import java.util.*;
import java.io.*;
public class Main {
    static int[][] shape = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로 3줄
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로 3줄
            {0, 4, 8}, {2, 4, 6}             // 대각선 2줄
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    sb.append(st.nextToken());
                }
            }
            System.out.println(BFS(sb.toString()));
        }
    }

    private static int BFS(String s) {
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();
        queue.add(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            String out = queue.poll();
            int cnt = visited.get(out);

            if(out.equals("TTTTTTTTT")||out.equals("HHHHHHHHH")) return cnt;

            for (int i = 0; i < 8; i++) {
                String next = flip(out, shape[i]);
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, cnt + 1);
                }
            }
        }

        return -1;
    }

    private static String flip(String out, int[] ints) {
        char[] chars = out.toCharArray();
        for (int idx : ints) {
            if(chars[idx]=='H') chars[idx] = 'T';
            else chars[idx] = 'H';
        }
        return new String(chars);
    }


}
