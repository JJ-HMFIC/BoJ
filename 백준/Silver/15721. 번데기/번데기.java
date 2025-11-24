
import java.util.*;

public class Main {
    static int A, T, num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        T = sc.nextInt();
        num = sc.nextInt();

        System.out.println(play());
    }

    private static int play() {
        int cnt = 0; // n번째 사람
        int cntZero = 0; // 뻔 외친 횟수
        int cntOne = 0; // 데기 외친 횟수

        int cycle = 1; //n회차 사이클

        outer:
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) cntZero++;
                else cntOne++;
                cnt++;
                if (num == 0 && cntZero == T) break outer;
                if (num == 1 && cntOne == T) break outer;
            }

            for (int i = 0; i <= cycle; i++) {
                cntZero++;
                cnt++;
                if (num == 0 && cntZero == T) break outer;
            }

            for (int i = 0; i <= cycle; i++) {
                cntOne++;
                cnt++;
                if (num == 1 && cntOne == T) break outer;
            }

            cycle++;
        }
        return (cnt - 1) % A; // 마지막에 항상 cnt++ 하므로
    }
}

