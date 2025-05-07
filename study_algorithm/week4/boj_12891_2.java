package study_algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891_2 {
    static int[] current; // 윈도우에 들어간 문자열의 상태(A,C,G,T)
    static int[] check; // 문제, 입력에서 주어지는 조건 4자리(A,C,G,T)
    static int result;
    // 한 자리(A,C,G,T)가 일치하면 +1 => 4자리 다 일치하면 하나 찾은 것

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());// 전체 문자열의 길이
        int P = Integer.parseInt(st.nextToken());// 부분 문자열의 길이

        char[] input = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        check = new int[4];
        current = new int[4];
        result = 0;
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) result++;
            // 조건의 문자가 0개일 경우 -> 상관없이 카운트
            // 해당 문자열이 있어도 되고 없어도 되기 때문
        }
        for (int i = 0; i < P; i++) {
            Add(input[i]);
            // 초기 부분 문자열을 윈도우에 넣기
            // 넣어서 check(조건)와 비교
        }
        if (result == 4) answer++;
        // ★ 초기 윈도우가 조건을 만족하면 하나 찾은 것
        // 빼먹어서 틀림..

        for (int i = P; i < S; i++) {
            // P-1 까지 윈도우에 넣었으니 다음 윈도우 값은 P
            int j = i - P;
            // 맨 앞 값 -> 인덱스 0부터 윈도우에서 빼야하니까
            Add(input[i]);
            Remove(input[j]);
            if (result == 4) answer++;
        }
        System.out.println(answer);

    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                current[0]++;
                if (current[0] == check[0]) result++;
                // 동일할때만 결과+1
                // why? 한번만 올리면 되기 때문에, 이상일 경우 이미 만족중임
                break;
            case 'C':
                current[1]++;
                if (current[1] == check[1]) result++;
                break;
            case 'G':
                current[2]++;
                if (current[2] == check[2]) result++;
                break;
            case 'T':
                current[3]++;
                if (current[3] == check[3]) result++;
                break;

        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (current[0] == check[0]) result--;
                // 기대치를 못미치기 때문에 result에 바로 반영
                current[0]--;
                break;
            case 'C':
                if (current[1] == check[1]) result--;
                current[1]--;
                break;
            case 'G':
                if (current[2] == check[2]) result--;
                current[2]--;
                break;
            case 'T':
                if (current[3] == check[3]) result--;
                current[3]--;
                break;

        }
    }
}
