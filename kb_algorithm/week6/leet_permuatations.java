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
        if (integers.size() == nums.length) { // 순서를 다 정했으면
            answers.add(new ArrayList<>(integers));
            return; // 순열의 경우의 수 담기
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문하고
                integers.add(nums[i]); //담고
                Per(answers,nums,integers); // dfs돌리고
                integers.remove(integers.size() - 1);
                visited[i] = false;
                // 백트래킹 처리
            }
        }

    }
}
