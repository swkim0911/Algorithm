import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        // for(int i = 1; i < n; i++){
        //     elements[i] = elements[i] + elements[i-1];
        // }
        Set<Integer> set = new HashSet<>();
        for(int l = 1; l <= n; l++){
            if(l == n){
                int sum = 0;
                for(int i = 0; i < n; i++){
                    sum += elements[i];
                }
                set.add(sum);
                continue;
            }
            for(int s = 0; s < n; s++){
                int sum = 0;
                for(int i = s; i < s + l; i++){
                    int p = i % n;
                    sum += elements[p];
                }
                set.add(sum);
                
            }
        }
        return set.size();
    }
}

// 누적합