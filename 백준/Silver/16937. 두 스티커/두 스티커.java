import java.util.*;
import java.io.*;

public class Main {
    static Sticker[] arr, result;
    static boolean[] visited;
    static int max, N, H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        arr = new Sticker[N];
        result = new Sticker[2];
        visited = new boolean[N];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Sticker(r, c);
        }
        fill(0, 0);
        System.out.println(max);
    }

    private static void fill(int cnt, int start) {
        if (cnt == 2) {
            if (check()) {
                max = Math.max(result[0].getArea() + result[1].getArea(), max);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            result[cnt] = arr[i];
            fill(cnt + 1, i + 1);
        }
    }

    private static boolean check() {
        Sticker one = result[0];
        Sticker two = result[1];
        if (one.getArea() + two.getArea() > H * W) return false;
        if (fit(one.r, one.c, two.r, two.c)) return true; // 정방향 + 정방향
        if (fit(one.r, one.c, two.c, two.r)) return true; // 정방향 + 회전
        if (fit(one.c, one.r, two.r, two.c)) return true; // 회전 + 정방향
        if (fit(one.c, one.r, two.c, two.r)) return true; // 회전 + 역방향
        return false;
    }
    
    private static boolean fit(int r1, int c1, int r2, int c2) {
        if (r1 + r2 <= H && Math.max(c1,c2) <= W) return true; 
        // 양 옆으로 붙일 때 , || , 세로는 둘 중 큰 값이 W를 벗어나지 않으면 된다
        if (Math.max(r1,r2)<=H && c1+c2 <= W) return true;
        // 위 아래로 붙일 때,=, 가로는 둘 중 큰 값이 H를 벗어나지 않으면 된다
        return false;
    }

}

class Sticker {
    int r;
    int c;

    public Sticker(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getArea() {
        return r * c;
    }
}
