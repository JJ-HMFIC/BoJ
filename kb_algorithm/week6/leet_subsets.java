package kb_algorithm.week6;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();

        sub(nums, new ArrayList<Integer>(), 0);

        return answer;
    }

    private void sub(int[] nums, ArrayList<Integer> path, int start) {
        answer.add(new ArrayList<>(path));
        // path 리스트 복사해서 넣기

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);//요소 넣고 
            sub(nums, path, i + 1); // 큰 요소 넣기
            path.remove(path.size() - 1); //백트래킹
        }
    }
}