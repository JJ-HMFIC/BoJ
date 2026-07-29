import java.util.*;

class Solution {
    static int time;
    static int[] result;
    public int solution(int[][] jobs) {
        time = 0;
        result = new int[jobs.length];
        PriorityQueue<Job> pq = new PriorityQueue<>();
        PriorityQueue<Job> pq2 = new PriorityQueue<>((o1,o2)->{
           return Integer.compare(o1.l, o2.l);
        });
        for(int i = 0; i<jobs.length;i++){
            pq.add(new Job(i,jobs[i][0],jobs[i][1]));
        }
        int cnt = 0;
        while(cnt < jobs.length){
            while (!pq.isEmpty() && pq.peek().s<=time){
                pq2.add(pq.poll());
            }// 요청시간이 현재 시간보다 이전인 작업들 다 큐에 넣기
            if(pq2.isEmpty()){
                time = pq.peek().s;
            }else{
                Job top = pq2.poll();
                
                time += top.l;
                result[top.idx] = (time-top.s);
                cnt++;
            }
        }
        
        
        int answer = 0;
        for(int i=0;i<result.length;i++){
            answer+= result[i];
        }
        return answer/result.length;
    }
    static class Job implements Comparable<Job>{
        int idx;
        int s;
        int l;
        
        public Job(int idx, int s, int l){
            this.idx =idx;
            this.s = s;
            this.l = l;
        }
        public int compareTo(Job j){
            if(this.s != j.s) return Integer.compare(this.s, j.s);
            return Integer.compare(this.l, j.l);
        }
    }
}