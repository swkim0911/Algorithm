import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryIdx = n - 1;
        int pickupIdx = n - 1;
        while(deliveryIdx != -1 || pickupIdx != -1){
            int tmp = cap;
            boolean isFirst = true;
            int dist = 0;
            int i = 0;
            for(i = deliveryIdx; i >= 0; i--){
                if(deliveries[i] == 0) continue;
                if(isFirst){
                    dist = i+1;
                    isFirst = false;
                }
                if(tmp - deliveries[i] <= 0){
                    deliveries[i] -= tmp;
                    break;
                }
                tmp -= deliveries[i];
                deliveries[i] = 0;
            }
            deliveryIdx = i;
            isFirst = true;
            tmp = cap;
            
            for(i = pickupIdx; i >= 0; i--){
                if(pickups[i] == 0) continue;
                if(isFirst){
                    dist = Math.max(i+1, dist);
                    isFirst = false;
                }
                if(tmp - pickups[i] <= 0){
                    pickups[i] -= tmp;
                    break;
                }
                tmp -= pickups[i];
                pickups[i] = 0;
            }
            pickupIdx = i;
            answer += (long)(2*dist);
        }
        return answer;
    }
}
// 그리디
// 시간 복잡도: n^2
// deliveryCursor = n - 1
// pickupCursor = n - 1