import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<Missile> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1.end, o2.end);
        });
        for(int[] target : targets){
            pq.add(new Missile(target[0],target[1]));
        }
        
        int answer = 1;
        int target = pq.poll().end;
        
        while(!pq.isEmpty()){
            Missile cur = pq.poll();
            if(cur.start<target) continue;
            target = cur.end ;
            answer++;
        }
        
        
        return answer;
    }
    public static class Missile{
        int start, end;
        public Missile(int start, int end){
            this.start = start;
            this.end =end;
        }
    }
}