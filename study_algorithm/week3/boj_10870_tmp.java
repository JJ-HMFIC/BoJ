package study_algorithm.week3;

import java.util.Scanner;

public class boj_10870_tmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int a = 0, b = 1;

        for (int i = 2; i <= N; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }

        System.out.println(b);
    }
}
