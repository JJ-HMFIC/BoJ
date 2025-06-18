package study_algorithm.week8;

import java.util.Scanner;

public class boj_1256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // a의 개수
        int M = sc.nextInt(); // b의 개수
        int K = sc.nextInt();

        int[][] D = new int[202][202]; // 조합으로 만들수 있는 경우의 수

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    // 조합 점화식 ★★★
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001;
                    //범위를 벗어나면 최댓값 설정
                }
            }
        }
        if (D[N + M][M] < K) { // 주어진 자리수로 만들 수 없는 경우라면
            System.out.println(-1);
        } else {
            while (!(N == 0 && M == 0)) {
                if (D[N + M - 1][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - D[N + M - 1][M];
                    M--;
                }
            }
        }
    }
}
