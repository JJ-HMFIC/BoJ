import java.util.*;
import java.io.*;

public class Main {
    static int max, N, M;
    static int[] result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[3];

        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(max);

    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
           int sum = 0;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                tmp = Math.max(arr[i][result[0]], arr[i][result[1]]);
                tmp = Math.max(tmp, arr[i][result[2]]);
                sum += tmp;
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = start; i < M; i++) {
            result[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}
