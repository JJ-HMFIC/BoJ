package kb_algorithm.week6;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        visited = new boolean[nums.length];
        Per(answers, nums, new ArrayList<Integer>());
        return answers;
    }

    private void Per(List<List<Integer>> answers, int[] nums, ArrayList<Integer> integers) {
        if (integers.size() == nums.length) {
            answers.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                integers.add(nums[i]);
                Per(answers,nums,integers);
                integers.remove(integers.size() - 1);
                visited[i] = false;
            }
        }

    }
}
