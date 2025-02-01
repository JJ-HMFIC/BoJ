package boj_test;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) A[i] = sc.nextInt();
        Arrays.sort(A);
        int result = A[A.length - 1] - A[0];
        System.out.println(result);
    }
}
