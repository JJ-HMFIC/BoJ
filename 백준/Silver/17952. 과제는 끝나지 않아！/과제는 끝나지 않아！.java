import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Info> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int T = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                if (A == 1) {
                    answer += T;
                    continue;
                }
                stack.push(new Info(T, A - 1));
            } else if (command == 0) {
                if (!stack.isEmpty()) {
                    Info top = stack.pop();
                    if (top.A - 1 == 0) {
                        answer += top.T;
                        continue;
                    }
                    stack.push(new Info(top.T, top.A - 1));
                }
            }
        }
        System.out.println(answer);
    }

    public static class Info {
        int T, A;

        public Info(int T, int A) {
            this.T = T;
            this.A = A;
        }
    }
}
