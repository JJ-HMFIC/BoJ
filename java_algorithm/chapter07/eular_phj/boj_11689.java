import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // i가 n의 약수일 경우
                result = result - result / i; // 오일러피 실행
                while (n % i == 0) n /= i; // n에서 i 소인수 모두 제거
            }
        }
        if (n > 1) { //n 자체가 소수라는 뜻(이 조건에 부합하다면)
            result = result - result / n; // 마지막으로 업데이트
        }
        System.out.println(result);
    }
}
