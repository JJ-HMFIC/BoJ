package boj_test;

import java.util.Scanner;

public class boj_15953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] A = new int[]{500, 300, 200, 50, 30, 10};
        int[] B = new int[]{512, 256, 128, 64, 32};

        for (int i = 0; i < T; i++) {
            int money = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 1) {
                money += A[0];
            } else if (a > 1 && a <= 3) {
                money += A[1];
            }else if (a > 3 && a <= 6) {
                money += A[2];
            }else if (a > 6 && a <= 10) {
                money += A[3];
            }else if (a > 10 && a <= 15) {
                money += A[4];
            } else if (a > 15 && a <= 21) {
                money += A[5];
            } else {
                money += 0;
            }

            if (b == 1) {
                money += B[0];
            } else if (b > 1 && b <= 3) {
                money += B[1];
            }else if (b > 3 && b <= 7) {
                money += B[2];
            }else if (b > 7 && b <= 15) {
                money += B[3];
            } else if (b > 15 && b <= 31) {
                money += B[4];
            }

            System.out.println(money*10000);
        }
    }
}
