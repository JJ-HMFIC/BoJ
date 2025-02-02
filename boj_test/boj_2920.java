package boj_test;

import java.util.Scanner;

public class boj_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int asc = 0;
        int desc = 0;
        for (int i = 0; i < 7; i++) {
            if (arr[i + 1] > arr[i]) {
                asc+=1;
            } else if (arr[i + 1] < arr[i]) {
                desc += 1;
            } else {
                continue;
            }
        }
        if (asc == 7) {
            System.out.println("ascending");
        } else if (desc == 7) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
