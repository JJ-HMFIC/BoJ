package kb_algorithm.week6;

class Solution {
    static boolean[] visited;

    public int solution(int[] numbers, int target) {

        int result = dfs(numbers, target, 0, 0);
        return result;
    }

    private int dfs(int[] numbers, int target, int index, int current) {
        if (index == numbers.length) {
            return (current == target) ? 1 : 0;
        }

        int sum = 0;
        sum += dfs(numbers, target, index + 1, current + numbers[index]);
        sum += dfs(numbers, target, index + 1, current - numbers[index]);
        return sum;

    }
}