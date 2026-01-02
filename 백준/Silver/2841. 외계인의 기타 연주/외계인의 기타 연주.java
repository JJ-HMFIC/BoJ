
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer>[] stack = new Stack[7];
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Stack<>();
        }

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            //높은 프렛 다 빼기
            while (!stack[line].isEmpty() && stack[line].peek() > fret) {
                stack[line].pop();
                cnt++;
            }
            // 같은 음을 누르고 있다면 넘어가기
            if(!stack[line].isEmpty() && stack[line].peek()==fret) continue;
            // 음 누르기
            stack[line].push(fret);
            cnt++;
        }
        System.out.println(cnt);
    }
}
