package boj_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        int[] A = new int[N];

        for (int i = 0; i < B.length; i++) B[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < B.length; i++) {
            A[i] = B[i] * (i + 1) - sum;
            sum += A[i];
            System.out.print(A[i]+ " ");
        }



    }
}
