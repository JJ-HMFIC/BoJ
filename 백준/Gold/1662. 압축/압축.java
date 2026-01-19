import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0; //문자열의 길이
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp == '(') {
                cnt -= 1;
                int mul = input.charAt(i - 1) - '0'; // 괄호 앞 숫자 = 곱해야할 숫자
                stack.push(cnt);
                stack.push(mul);

                cnt = 0;
            } else if (tmp == ')') {
                int mul = stack.pop(); // 곱해야할 숫자
                int front = stack.pop(); // 앞단의 길이

                cnt = cnt * mul + front; // cnt(괄호 안 길이) * 곱해야할 숫자 + 바깥쪽 길이
            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
