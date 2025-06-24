package kb_algorithm.week6;

class Solution {
    static boolean[] visited;

    public int solution(int[] numbers, int target) {

        int result = dfs(numbers, target, 0, 0);
        return result;
    }

    private int dfs(int[] numbers, int target, int index, int current) {
        if (index == numbers.length) {
            //인덱스가 끝에 도달 = 문자열의 길이
            return (current == target) ? 1 : 0;
        }

        int sum = 0;
        sum += dfs(numbers, target, index + 1, current + numbers[index]);
        // 해당 인덱스를 더할 때
        sum += dfs(numbers, target, index + 1, current - numbers[index]);
        // 해당 인덱스를 뺄 때
        // 0부터 시작하니 첫 값부터 +/-를 둘 다 고려하여 시작한다
        return sum;

    }
}