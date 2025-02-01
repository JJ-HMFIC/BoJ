package boj_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int bonus = 0;
        int sum = 0;
        String arr = br.readLine();
        for (int i = 0; i < N; i++) {
            if (arr.charAt(i) == 'O') {
                sum += (i+1) + bonus;
                bonus += 1;
            } else {
                bonus = 0;
            }
        }
        System.out.println(sum);

    }
}
