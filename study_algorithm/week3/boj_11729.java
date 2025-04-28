package study_algorithm.week3;

import java.util.Scanner;

public class boj_11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println((int) Math.pow(2, N)-1);
        hanoi(N, 1,2 ,3 );
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid, int dest) {
        if( N == 1 ) {
//            System.out.println(start + " " + dest);
            sb.append(start).append(" ").append(dest).append("\n");
            return;
        }
        hanoi(N - 1, start, dest, mid);
//        System.out.println(start + " " + dest);
        sb.append(start).append(" ").append(dest).append("\n");
        hanoi(N - 1, mid, start, dest);
    }
}
