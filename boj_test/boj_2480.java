package boj_test;

import java.util.Scanner;

public class boj_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long result = 0;
        if (a == b && b == c) {
            result = 10000 + a * 1000;
        } else if (a==b || a==c) {
            result = 1000 + a * 100;
        } else if (b==c) {
            result = 1000 + b * 100;
        } else {
            long max = Math.max(a, Math.max(b, c));
            result = max * 100;
        }
        System.out.println(result);
    }
}
