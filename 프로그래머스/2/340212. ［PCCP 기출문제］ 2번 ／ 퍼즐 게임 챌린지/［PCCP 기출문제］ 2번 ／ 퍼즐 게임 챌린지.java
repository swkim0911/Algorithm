class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        int left = 1;
        int right = 100_000;
        while (left < right){
            int mid = (left + right) / 2;
            long time = getTotalTime(diffs, times, n, mid);
            if(time > limit){
                left = mid + 1;
            }else if(time <= limit){
                right = mid;
            }
        }
        answer = right;
        return answer;
    }
    
    public long getTotalTime(int[] diffs, int[] times, int n, int level){
        long total = 0;
        for(int i = 0; i < n; i++){
            int diff = diffs[i];
            int time = times[i];
            if(level >= diff){
                total += time;
            }else{
                total += (diff - level) * (time + times[i-1]) + time;
            }
        }
        
        return total;
    }
}

// 이분 탐색