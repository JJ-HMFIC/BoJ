import java.util.*;

public class Main {
    static List<Integer> list;
    static int[] tmp;
    static boolean[] select;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] record = new String[N];
        int[] strike = new int[N];
        int[] ball = new int[N];

        for (int i = 0; i < N; i++) {
            record[i] = sc.next();
            strike[i] = sc.nextInt();
            ball[i] = sc.nextInt();
        }
        list = new ArrayList<>();
        tmp = new int[3];
        select = new boolean[9];
        permutation(0);

        int answer = 0;
        for (int num : list) {
            String myNum = String.valueOf(num);
            boolean isPossible = true;

            for (int i = 0; i < N; i++) {
                String target = record[i];

                int tmpStrike = 0;
                int tmpBall = 0;
                for (int j = 0; j < 3; j++) {
                    if (target.charAt(j) == myNum.charAt(j)) tmpStrike++;
                    else if (target.contains(String.valueOf(myNum.charAt(j)))) {
                        /*if (target.indexOf(myNum.charAt(j)) != j)*/
                        tmpBall++;
                    }
                }
                if (tmpStrike != strike[i] || tmpBall != ball[i]) {
                    isPossible = false;
                }
            }
            if(isPossible) {
                answer++;
            }

        }
        System.out.println(answer);

    }

    private static void permutation(int cnt) {
        if (cnt == 3) {
            list.add(tmp[0] * 100 + tmp[1] * 10 + tmp[2]);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (select[i]) continue;

            select[i] = true;
            tmp[cnt] = i + 1;
            permutation(cnt + 1);
            select[i] = false;
        }
    }
}
