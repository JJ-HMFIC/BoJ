package kb_algorithm.week5;


public class pro_prefix_sum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int N = sequence.length;

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;

        while (right < N) {
            if (sum == k) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
                // 왼쪽을 증가시키는 이유
                // 오른쪽을 즏가시키면 -> 배열의 끝을 넘어가 종료될 수 있음
                // 이 경우 짧은 구간을 찾기 전에 반복문 종료
            } else if (sum < k) {
                right++;
                if (right < N) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }
        return answer;
    }
}
