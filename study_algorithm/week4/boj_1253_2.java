package study_algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int count = 1; // 자기 자신을 포함

        while (start < end) {
            if (arr[start] + arr[end] == N) {
                if(start == end) count++;
                else count += 2;
                end--;
            } else if (arr[start] + arr[end] < N) {
                start++;
            } else end--;
        }
        System.out.println(count);
    }
}
