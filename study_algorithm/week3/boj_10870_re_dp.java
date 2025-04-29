package study_algorithm.week3;

import java.util.Scanner;

public class boj_10870_re_dp {
    static int[] memo = new int[21]; // 문제에서 N ≤ 20이니까 배열 크기 충분

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibo(N));
    }

    static int fibo(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        if (memo[N] != 0) { // 이미 계산한 적 있다면 바로 반환
            return memo[N];
        }

        // 계산하고 저장
        return memo[N] = fibo(N-1) + fibo(N-2);
    }
}

