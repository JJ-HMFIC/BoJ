import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for(int i = 0 ; i<jobs.length; i++){
            pq.add(new Job(i,jobs[i][0],jobs[i][1]));
        }
        int[] result = new int[jobs.length];
        int time = 0;
        PriorityQueue<Job> wpq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1.l, o2.l);
        });
        int cnt = 0;
        while(cnt < jobs.length){
            while(!pq.isEmpty() && pq.peek().s <= time){
                wpq.add(pq.poll());
            }
            if(wpq.isEmpty()){
                time = pq.peek().s;
                continue;
            }else{
                Job top = wpq.poll();
                time += top.l;
                result[top.idx] = time - top.s;
                cnt++;
            }
        }
        
        int answer = 0;
        for(int i : result) answer+=i;
        return answer/jobs.length;
    }
    public class Job implements Comparable<Job>{
        int idx;
        int s;
        int l;
        public Job(int idx, int s, int l){
            this.idx = idx;
            this.s = s;
            this.l = l;
        }
        public int compareTo(Job o){
            return Integer.compare(this.s, o.s);
        }
    }
}