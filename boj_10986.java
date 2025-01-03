import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_10986 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt((st.nextToken()));
        int M = Integer.parseInt((st.nextToken()));
        long[] S = new long[N];
        long[] C = new long[M]; // 나머지가 0,1,.. M-1 이 몇개 있는지 체크하는 배열
        long answer = 0;
        st = new StringTokenizer(bf.readLine());
        S[0] = Integer.parseInt((st.nextToken()));
        for (int i = 1; i < N; i++) S[i] = S[i - 1] + Integer.parseInt((st.nextToken()));; // 합 배열 만들기
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) answer++;
            C[remainder]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += ((C[i] * (C[i] - 1)) / 2);
            }
        }
        System.out.println(answer);
    }
}
