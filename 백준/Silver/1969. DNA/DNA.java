import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static String[] arr;
    static char[] dna = new char[]{'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int dist = 0;
        for (int j = 0; j < M; j++) {
            int[] count = new int[4]; // A,C,G,T
            for (int i = 0; i < N; i++) {
                char c = arr[i].charAt(j);
                if (c == 'A') count[0]++;
                if (c == 'C') count[1]++;
                if (c == 'G') count[2]++;
                if (c == 'T') count[3]++;
            }
            int max = 0;
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                if (count[i] > max) {
                    max = count[i];
                    idx = i;
                }
            }// 가장 많이 나온 dna 알아내기
            sb.append(dna[idx]);
            dist += N - max;// 전체 개수 - 최빈값 = 거리 
        }
        System.out.println(sb);
        System.out.println(dist);
    }
}
// distance 합이 가장 적은 dna -> 각 자리에서 가장 많이 나온 dna
