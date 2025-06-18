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
        }

        for (int i = start; i <= n; i++) {
//            if (!integers.isEmpty() && i <= integers.get(0)) continue;
            integers.add(i);
            Com(n, k, i+1,integers);
            integers.remove(integers.size() - 1);
        }
    }
}
