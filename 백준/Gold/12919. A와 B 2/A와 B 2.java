
import java.util.*;
import java.io.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();
        answer = 0;
        AB(T, S);
        System.out.println(answer);
    }

    private static void AB(String T, String S) {

        if (T.equals(S)) {
            answer = 1;
            return;
        }
        if (T.length() <= S.length()) return;

        if (T.charAt(T.length() - 1) == 'A') {
            AB(T.substring(0, T.length() - 1), S);
        }

        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(T.substring(1));
            AB(sb.reverse().toString(), S);
        }

    }

}
