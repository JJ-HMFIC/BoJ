package kb_algorithm.week6;

import java.util.*;

class Solution {
    static List<List<Integer>> answer;

    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        Com(n, k,1,  new ArrayList<Integer>());

        return answer;
    }

    private void Com(int n, int k, int start, ArrayList<Integer> integers) {
        if (integers.size() == k) {
            answer.add(new ArrayList<>(integers));
            return;
            //사이즈가 k라면 -> 순열과 다른 점
        }

        for (int i = start; i <= n; i++) {
//            if (!integers.isEmpty() && i <= integers.get(0)) continue;
            integers.add(i);
            // 요소를 담고
            Com(n, k, i+1,integers);
            // 현재 요소보다 큰 요소부터 조합 돌리기 -> 중복 방지
            integers.remove(integers.size() - 1);
            // 백트래킹 처리
        }
    }
}
