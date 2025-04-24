package kb_algorithm.week1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class pro_develop {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 작업 일수 계산
            int tmp = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(tmp);
        }
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int cnt = 1;
            while (!queue.isEmpty() && queue.peek() <= cur) {
                //현재 일수보다 작은 일수 다 제거
                queue.remove();
                cnt++;
                // 현재 일수보다 더 적게 걸리는 작업은
                // 현재 일수와 같이 출시하게 됌 => cnt++ , queue에서 제거
            }
            // 내부 while을 한번 돌리면 현재 일수보다 긴 일수만 남음
            list.add(cnt);
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        } // 요구 사항: 정수 배열 리턴 => 리스트를 정수 배열로 옮겨 딤기

        return ans;
    }
}
