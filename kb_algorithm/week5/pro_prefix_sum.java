package kb_algorithm.week5;


public class pro_prefix_sum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2]; // left, right 담을 배열

        int N = sequence.length;

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE; // left,right가 최소 길이인지 판별하는 변수

        while (right < N) { // 배열을 벗어나지 않을 때 까지
            if (sum == k) { // 합이 k라면
                if (right - left < minLen) {
                    // 구간이 앞에서 구한 최소 길이보다 작을 경우
                    minLen = right - left; // 구간을 업데이트하고
                    answer[0] = left;
                    answer[1] = right; // 답을 구한다
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
