package boj_test;

import java.util.Scanner;

public class boj_2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[101];
        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (arr[i] == 1) {
                sum += A * 1;
            } else if (arr[i] == 2) {
                sum += B * 2;
            }else if(arr[i]==3){
                sum += C * 3;
            }
        }
        System.out.println(sum);
        
    }
}
