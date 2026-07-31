import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Number> deque = new ArrayDeque<>();
        for(int i = 0 ; i<priorities.length;i++){
            deque.add(new Number(i,priorities[i]));
            pq.add(priorities[i]);
        }
        int answer = 0;
        while(!deque.isEmpty()){
            Number top = deque.poll();
            if(top.num == pq.peek()){
                answer++;
                pq.poll();
                if(top.idx == location) return answer;
            }else{
                deque.add(top);
            }
            
        }

        return answer;
    }
    static class Number{
        int idx;
        int num;
        public Number(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}