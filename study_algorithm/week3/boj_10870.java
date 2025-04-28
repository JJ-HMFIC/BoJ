package study_algorithm.week3;

import java.util.Scanner;

public class boj_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = fibo(N);

        System.out.println(result);
    }

    static int fibo(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fibo(N - 1) + fibo(N - 2);
    }

}
