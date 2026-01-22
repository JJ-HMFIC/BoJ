
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Info> queue = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            queue.add(new Info(s, n));
        }

        while (queue.size() > 1) {
            Info top = queue.poll();
            for (int i = 0; i < top.studentID - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        Info answer = queue.poll();
        System.out.println(answer.Initial);
    }

    public static class Info {
        String Initial;
        int studentID;

        public Info(String initial, int studentID) {
            Initial = initial;
            this.studentID = studentID;
        }
    }
}
