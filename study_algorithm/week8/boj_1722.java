package study_algorithm.week8;

import java.util.*;

public class boj_1722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] fact = new long[21]; // N이 20까지니까
        fact[0] = 1;
        for (int i = 1; i < 21; i++) fact[i] *= fact[i - 1]; // 팩토리얼 계산

        int N = sc.nextInt();
        int menu = sc.nextInt(); // 1번? 2번?

        if (menu == 1) { // 1번: k번째 순열 구하기
            long k = sc.nextLong();
            boolean[] used = new boolean[N + 1];
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < N; i++) { // i+1번 째 자리
                for (int j = 1; j <= N; j++) { // 해당 자리에 들어갈 수 j
                    if (used[j]) continue;

                    if (fact[N - 1 - i] < k) {
                        // 왜 N-1-i 일까
                        // i 자리 고르고 나머지 (N-1)!
                        k -= fact[N - 1 - i];
                    } else {
                        result.add(j);
                        used[j] = true;
                        break;
                    }
                }
            }
            for (int num : result) System.out.println(num + " ");
        } else { //2번 : 현재 순열이 몇 번째인지
            int[] arr = new int[N];
            boolean[] used = new boolean[N + 1];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            long result = 0;
            
            for (int i = 0; i < N; i++) {
                int cur = arr[i]; // 현재 자리 수
                int able = 0;
                for (int j = 1; j < cur; j++) {
                    if(!used[j]) able++;
                } // 현재 자리수 보다 작은 수 중 사용 가능한 수 세기

                result += able * fact[N - 1 - i];
                used[cur] = true;
            }
            System.out.println(result + 1);
        }
    }
}
