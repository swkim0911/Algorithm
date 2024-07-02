import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 먼저 도착한 것을 빠르게 처리 하기 위함.
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]); // 요청되는 시점 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]); // 소요 시간 오름차순
        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end){ // 작업이 끝나는 시점 전에 요청된 job들
                pq.add(jobs[index++]);
            }
            if(pq.isEmpty()){
                end = jobs[index][0];
            }else{
                int[] cur = pq.poll();
                total += end + cur[1] - cur[0];
                end += cur[1];
                count++;
            }
        }
        return total / jobs.length;
    }
}
