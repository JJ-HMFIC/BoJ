import java.util.Scanner;

public class boj_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        boolean[] check = new boolean[(int) (Max - Min + 1)];
        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i;
            long start_index = Min / pow;
            if( Min%pow !=0) start_index++; // 나머지가 있으면 더해줘야 Min보다 큰 제곱수에서 시작
            for (long j = start_index; pow * j <= Max; j++) {
                check[(int)((j * pow) - Min)] = true;
                // j×pow는 Min 기준으로 얼마나 떨어져 있는지 계산하여 해당 인덱스를 true로 설정
                // 이 값을 true로 바꾸면 제곱수의 배수임을 표시
            }
        }
        int count = 0;
        for (int i = 0; i <= Max-Min; i++) {
            if (!check[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
