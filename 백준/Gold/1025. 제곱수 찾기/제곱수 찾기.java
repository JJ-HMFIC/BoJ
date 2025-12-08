import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = -1;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        answer = -1;
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N + 1; di <= N - 1; di++) {
                    for (int dj = -M + 1; dj <= M - 1; dj++) {
                        if (di == 0 && dj == 0) {
                            if (isDouble(arr[i][j])) answer = Math.max(answer, arr[i][j]);
                            continue;
                        }

                        int ni = i;
                        int nj = j;
                        int now = 0;

                        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            now *= 10;
                            now += arr[ni][nj];

                            if(isDouble(now)) answer = Math.max(answer, now);

                            ni += di;
                            nj += dj;
                        }
                    }
                }
                
            }
        }
        System.out.println(answer);
    }

    public static boolean isDouble(long num) {
        long root = (long) Math.sqrt(num);
        return num == root * root;
    }
}
