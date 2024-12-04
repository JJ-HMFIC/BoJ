import java.io.*;

public class boj_10989 {
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());
        radix_sort(A, 5);
        for (int i = 0; i < N; i++) {
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radix_sort(int[] A, int max_size) { //max_size = 최대 자릿수
        int[] output = new int[A.length];
        int jarisu = 1; //1,10,100 자리수
        int cnt = 0;
        while (cnt != max_size) {
            int[] bucket = new int[10]; // bucket: 각 자리수의 숫자(0~9)에 대한 빈도수를 저장하는 배열
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i]/ jarisu) % 10]++;
            } // 자리수 저장
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length-1; i >= 0; i--) {
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i]; // 데이터 꺼내서 저장
                // -1로 0 기반 인덱스에 맞춤
                bucket[(A[i] / jarisu) % 10]--; // 인덱스에서 제거
            }
            for (int i = 0; i < A.length; i++) A[i] = output[i]; // 데이터 정렬
            jarisu *= 10;
            cnt++;
        }
    }
}
