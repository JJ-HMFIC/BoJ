package java_algorithm.chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] A = new long[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            long find = A[k];
            int i = 0;
            int j = N - 1;
            while (i < j) {
                if (A[i] + A[j] == find) { // 자기자신은 좋은수가 될수 없으므로
                    if (i != k && j != k) {
                        result++;
                        break;
                    }
                    else if (i==k) i++;
                    else if (j==k) j--;
                } else if (A[i] + A[j] < find) i++;
                else j--;
            }
        }
        System.out.println(result);
        bf.close();
    }
}
