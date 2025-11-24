import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String pureArr = arr.substring(1, arr.length() - 1);
            String[] digit = pureArr.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < digit.length; j++) {
                if(len!=0) deque.add(Integer.valueOf(digit[j]));
            }

            boolean error = false;
            int status = 0; // 0이면 앞, 1이면 뒤
            for (int j = 0; j < command.length(); j++) {
                char currentChar = command.charAt(j);
                if (currentChar == 'R') {
                    if(status==0) status = 1;
                    else status = 0;
                } else if (currentChar=='D') {
                    if (deque.size() <= 0) {
                        error = true;
                        break;
                    }
                    if (status == 0) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    if(status==0) sb.append(deque.pollFirst());
                    else sb.append(deque.pollLast());
                    sb.append(",");
                }
                if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
                sb.append("]");

                System.out.println(sb.toString());
            }

        }
    }
}
