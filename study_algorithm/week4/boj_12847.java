package study_algorithm.week4;

import java.util.Scanner;


public class boj_12847 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] pay = new long[n];

        for (int i = 0; i < n; i++) pay[i] = sc.nextLong();

        long sum = 0;

        for (int i = 0; i < m; i++) sum += pay[i];
        // 첫 m일의 합
        long max = sum;

        for (int i = m; i < n; i++) {
            sum = sum - pay[i - m] + pay[i];
            // m부터 맨 앞의 값 빼고, 맨 뒤의 값 더하기
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
