import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1; // 가능한 최소 거리 중 최솟값
        int right = distance; // 가능한 최소 거리 중 최댓값
        while(left <= right){
            int mid = (left + right) / 2; // mid: 가능한 최소 거리
            if(countRemovedRocks(mid, distance, rocks) <= n){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
    
    
    public int countRemovedRocks(int min, int distance, int[] rocks){
        int cnt = 0; // 최서 거리가 min일 때 제거해야 할 돌의 개수
        int cur = 0; // 기준이 되는 돌의 위치
        for(int rock : rocks){
            if(rock - cur < min) cnt++;
            else cur = rock;
        }
        if(distance - cur < min) cnt++;
        return cnt;
    }
}
//시간 복잡도: log(distance) * rocks = log(10억)*50,000