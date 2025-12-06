import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int win;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[19][19];
        win = 0;
        x = 0;
        y = 0;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (five(i, j, d)) {
                            System.out.println(arr[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean five(int i, int j, int d) {
        int color = arr[i][j];

        int px = i - dx[d];
        int py = j - dy[d];
        if (isValid(px, py) && arr[px][py] == color) {
            return false;
        }

        int nx = i;
        int ny = j;
        int cnt = 1;
        for (int k = 0; k < 4; k++) {
            nx += dx[d];
            ny += dy[d];
            if (isValid(nx, ny) && arr[nx][ny] == color) {
                cnt++;
            } else break;

        }
        if (cnt == 5) {
            nx += dx[d];
            ny += dy[d];
            if (isValid(nx, ny) && arr[nx][ny] == color) return false;
            return true;        }

        return false;

    }

    private static boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i > 18 || j > 18) {
            return false;
        }
        return true;
    }


}
