
import java.util.*;

public class Main {
    static int min, N;
    static int[] sour, bitter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sour = new int[N];
        bitter = new int[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }
        cook(0, 1, 0, 0);
        System.out.println(min);
    }

    private static void cook(int cnt, int first, int second, int selectedCount) {
        if (cnt == N) {
            if (selectedCount > 0) {
                min = Math.min(min, Math.abs(first - second));
            }
            return;
        }

        cook(cnt + 1, first * sour[cnt], second + bitter[cnt], selectedCount + 1);
        cook(cnt + 1, first, second, selectedCount);

    // selectedCount -> 아무것도 선택 안했을 때 확정적으로 1이나옴, 이를 방지하기 위해 조건 달기
    }
}
