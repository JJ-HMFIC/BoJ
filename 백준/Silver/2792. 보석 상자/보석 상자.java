import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int left = 1;
        int right = 0;
        int[] jewel = new int[M];
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            right = Math.max(jewel[i], right);
        }
        int answer = right;


        while (left <= right) {
            int mid = (left + right) / 2; // 질투심 : 한 명의 아이가 가져갈 수 있는 보석의 최대 개수

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int now = jewel[i];
                if (now % mid == 0) {
                    cnt += now / mid;
                } else {
                    cnt += now / mid + 1;
                }
            }// 아이마다 mid 개씩 같은 보석을 분배 함 , 딱 안나누어 떨어지면 짬처리(같은 보석만 집어가야 하므로)
            if (cnt > N) {// 그렇게 보석을 나눠 가졌는데 N명보다 크다면,
                left = mid + 1; // 나누어주는 보석의 수를 증가
            } else {
                answer = mid; //작으면 나누어주는 보석 수를 줄이기
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

}
