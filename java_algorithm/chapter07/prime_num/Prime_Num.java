import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime_Num {
    static boolean[] isPrime;

    static void isPrime_fun(int n) {
        isPrime = new boolean[n + 1]; // N번째의 수 까지 받기위해 N+1까지 동적할당

        for (int i = 0; i < isPrime.length; i++) isPrime[i] = true; // 일단 true로 초기화
        isPrime[0] = isPrime[1] = false;// 1과 0은 소수가 아님

        for (int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지의 모든 수를 확인
            if (isPrime[i]) {//i 가 소수라면
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false; // i의 배수는 모두 소수가 아님
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isPrime_fun(N);
    }
}
