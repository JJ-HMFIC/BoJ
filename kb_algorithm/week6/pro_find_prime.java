package kb_algorithm.week6;

import java.util.HashSet;
import java.util.Set;

class Solution {
//    static char[] letters;
    static boolean[] visited;
    static Set<Integer> answer;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
//        char[] letters = numbers.toCharArray();
        answer = new HashSet<>();

        permutation(numbers, "");

        if(answer.isEmpty()) return 0;

        return answer.size();
    }

    private void permutation(String numbers, String word) {
        if (!word.isEmpty()) {
            int num = Integer.parseInt(word);
            if(isPrime(num)) answer.add(num);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, word + numbers.charAt(i));
                visited[i] = false;
            }
        }

    }

    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}