import java.util.Scanner;

public class boj_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if(A[i]==0) continue;
            for (int j = i+i; j < A.length; j+=i) {
                A[j] = 0;
            }
        }
        int i = N;
        while (true) {
            if (A[i] != 0) { // 소수라면
                int result = A[i];
                if (isPalindrome(A[i])) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] tmp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = tmp.length - 1;
        while (s < e) {
            if (tmp[s] != tmp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
