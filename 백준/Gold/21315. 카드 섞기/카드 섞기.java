
import java.io.*;
import java.util.*;

public class Main {
    static int[] cards, input;
    static int N, k1, k2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k1 = 0;
        k2 = 0;
        input = new int[N]; // 입력으로 들어오는 카드 순서
        cards = new int[N]; // 초기 카드 순서 1~ N
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = i + 1;
            input[i] = Integer.parseInt(st.nextToken());
        }


        solve();
        System.out.println(k1+" "+k2);

    }

    private static void solve() {
        for (int i = 1; Math.pow(2, i) <= N; i++) { //k1
            for (int j = 1; Math.pow(2, j) <= N; j++) { //k2
                int[] arr = cards.clone();
                shuffle(i, arr); // i+1번 섞기
                shuffle(j, arr); // j+1번 섞기
                boolean check = true;
                for (int k = 0; k < N; k++) {
                    if (arr[k] != input[k]) {
                        check = false;
                        break;
                    } // 카드 순서와 같지 않으면 다시 검사해
                }
                if (check) { // 카드순서와 같으면 리턴
                    k1 = i;
                    k2 = j;
                    return;
                }
            }
        }
    }

    private static void shuffle(int k, int[] arr) {
        int range = N;
        int cnt;
        for (int i = 1; i <= k + 1; i++) {
            cnt = (int) Math.pow(2, k - i + 1); // 2^k-i+1 번째
            swap(range, cnt, arr);
            range = cnt;
        }

    }
    // 리스트에 넣고 그 자리를 0으로 두었다가
    // 리스트에서 하나씩 꺼내어 배열에 넣는 방식
    private static void swap(int range, int cnt, int[] arr) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = range - cnt; i < range; i++) {
            tmp.add(arr[i]);
            arr[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) {
                tmp.add(arr[i]);
            }
            arr[i] = tmp.get(i);
        }
    }


}
