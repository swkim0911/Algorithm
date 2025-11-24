import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = routes.length;
        Arrays.sort(routes, (o1,o2) -> {
           if(o1[0] == o2[0]){
               return o1[1] - o2[1];
           }
            return o1[0] - o2[0];
        });
        int start = routes[0][0];
        int end = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            int left = routes[i][0];
            int right = routes[i][1];
            if(left <= end){
                start = left;
                end = Math.min(end, right);
                answer -= 1;
            }else{
                start = left;
                end = right;
            }
        }
        
        return answer;
    }
}

// -20, -15
// -14, -5
// -18, -13
// -5, -3

// 최악: 10,000 * 60,000 = 600,000,000 = 6억 -> timeout
// 

