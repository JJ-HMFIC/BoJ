package kb_algorithm.week8;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // [a,b] ~ a : 요청 시간 , b : 소요 시간
        Arrays.sort(jobs, ((a, b) -> a[0] - b[0]));
        // 요청시간 오름 차순 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // 소요 시간 기준 최소 힙

        int time = 0; // 현재 시간
        int jobIndex = 0; // jobs 배열 순회 인덱스 ~ [0,0] <- 통째로 순회하려고
        int totalTime = 0; // 모든 작업을 수행하는데 걸린 총 시간
        int count = 0; // 완료된 작업 수

        while (count < jobs.length) { // 모든 작업이 완료될 대 까지
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                // 아직 작업이 남아있고 , 그 작업의 요청 시간이 지금 시간 이전이라면
                pq.offer(jobs[jobIndex]);
                // 큐에 넣고
                jobIndex++;
                // 큐에 넣은 작업의 개수 올리기
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                // 요청 시간이 짧은 순으로 작업 꺼내고
                time += job[1];
                // 시간은 지나간다
                totalTime += (time - job[0]);
                // 총 작업 시간 계산
                count++;
            } else {
                time++;
                // 큐가 비어 있을 수 있음 , 그러면 그냥 시간만 지난다
            }
        }
        return totalTime / jobs.length;
    }
}