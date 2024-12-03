import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Collections.swap;

public class boj_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        quicksort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quicksort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K) return;
            else if (K < pivot) {
                quicksort(A, S, pivot - 1, K);
                //구하고자 하는 수가 피벗보다 작으면
                // 피벗(?번째 수) 보다 왼쪽에 있을 테니, 왼쪽을 정렬

            }
            else {
                quicksort(A, pivot + 1, E, K);
                // 구하고자 하는 수가 피벗보다 크면
                // 피벗(?번째 수) 보다 오른쪽에 있을 테니, 오른쪽을 정렬
            }
        }
    }

    public static int partition(int[] A, int S, int E) { // 피벗의 위치를 알려주는 함수
        if (S + 1 == E) {
            if(A[S]>A[E]) swap(A, S, E);
            return E;
        } // 데이터가 2개인 경우 바로 비교하고 스왑 후 리턴
        int M = (S + E) / 2; // 중앙값을 먼저 위치선정 -> 작은 값, 큰값으로 쪼개서 또 위치선정 -> 반복
        swap(A, S, M);
        int pivot = A[S]; // i,j를 쉽게 움직이기 위해 중앙값과 처음값 스왑
        int i = S + 1, j = E;
        while (i <= j) {
            while (j >= S + 1 && pivot < A[j]) j--; // 피벗보다 작은 수가 나올때까지 j--
            while (i <= E && pivot > A[i]) i++; // 피벗보다 큰 수가 나올때까지 i++
            if (i <= j) { // 중간에 멈췄으면 탐색해야 할 수가 남아있음을 의미 , 교차될때까지 해야됌
                swap(A,i++,j--); // 바꾸고 계속 전진
            }
        }
        A[S] = A[j]; // j가 결국 피벗의 위치가 된다
        A[j] = pivot; // 둘이 바꿔고 , j 리턴
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
