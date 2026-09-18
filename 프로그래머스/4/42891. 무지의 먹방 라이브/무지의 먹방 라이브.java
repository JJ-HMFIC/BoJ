import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1.num, o2.num);
        });
        for(int i = 0; i<food_times.length;i++){
            pq.add(new Info(i+1, food_times[i]));
        }
        
        long total = 0;
        for(int food : food_times){
            total +=food;
        }
        if(total<=k) return -1;
        
        
        long prev = 0; // 몇바퀴 돌렸는지
        long len = food_times.length;
        while(true){
            int curFood = pq.peek().num;
            long cost = (curFood- prev) * len;
            
            if(k>=cost){ // 먹어 치울 수 있다면
                k-= cost; 
                prev = pq.poll().num; // 제거하기
                len --;
            }else{
                break;
            }
        }
        
        ArrayList<Info> list = new ArrayList<>(pq);
        list.sort((o1,o2)-> Integer.compare(o1.idx, o2.idx));
        
        
        return list.get((int)(k% len)).idx;
        
      
    }
    public class Info{
        int idx, num;
        
        public Info(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
        
        
        
    }
}