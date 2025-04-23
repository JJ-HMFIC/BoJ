package kb_algorithm.week1;

import java.util.ArrayDeque;
import java.util.Deque;

public class pro_stock_price {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // prices[i] : 입력 값
                // prices[stack.peek()] 스택에 들어간 값
                // prices[i]<prices[stack.peek()] -> 가격이 떨어졌다
                int idx = stack.pop(); // 현재 조사하는 자리
                ans[idx] = i - idx; // 떨어진 자리 - 현재 조사하는 자리
            }
            stack.push(i); // 다음 구하기
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = (prices.length - 1) - idx;
            // 다 돌렸는데 스택에 남아 있는 자리 = 가격이 안 떨어짐
        }
        return ans;

    }
}
