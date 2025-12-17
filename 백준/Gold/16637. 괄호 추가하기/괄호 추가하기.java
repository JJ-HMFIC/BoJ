
import java.io.*;
import java.util.*;

public class Main {
    static int half;
    static int max;
    static int[] numbers;
    static char[] operators;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        half = N / 2;
        numbers = new int[half + 1];
        operators = new char[half];
        int idxN = 0;
        int idxO = 0;

        String line = sc.next();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                numbers[idxN++] = line.charAt(i) - '0';
            } else operators[idxO++] = line.charAt(i);
        }
        max = Integer.MIN_VALUE;
        dfs(0, numbers[0]);
        System.out.println(max);

    }

    private static void dfs(int leftIdx, int sum) {
        if (leftIdx == half) {
            max = Math.max(max, sum);
            return;
        }
        // 괄호없이 진행하는 경우
        int rest = cal(sum, numbers[leftIdx + 1], operators[leftIdx]);
        dfs(leftIdx + 1, rest);
        //괄호 묶기
        if (leftIdx + 1 < half) {
            int tmp = cal(numbers[leftIdx + 1], numbers[leftIdx + 2], operators[leftIdx + 1]);
            int rest2 = cal(sum, tmp, operators[leftIdx]);
            dfs(leftIdx + 2, rest2);
        }

    }

    private static int cal(int a, int b, char op) {
        if(op=='+') return a + b;
        if(op=='-') return a - b;
        if(op=='*') return a * b;
        return 0;
    }
}
