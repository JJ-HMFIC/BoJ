import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        int n = input.length();
        long[] dp = new long[input.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char cur = input.charAt(i - 1);
            char prev = input.charAt(i - 2);

            if (cur != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }

            int twoDigit = (prev - '0') * 10 + (cur - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
            //$$dp[i] = (\text{한 자리로 해석한 수}) + (\text{두 자리로 묶어 해석한 수})$$$$dp[i] = dp[i-1] + dp[i-2]$$

        }
        System.out.println(dp[n]);
    }
}

