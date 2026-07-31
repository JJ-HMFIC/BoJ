import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i =0 ; i<progresses.length;i++){
            int day = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            deque.add(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!deque.isEmpty()){
            int top = deque.poll();
            int day = 1;
            while(!deque.isEmpty() && deque.peek()<=top){
                deque.poll();
                day++;
            }
            list.add(day);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}