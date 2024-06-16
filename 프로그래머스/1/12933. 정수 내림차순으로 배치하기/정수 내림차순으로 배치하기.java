import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        int[] list = new int[str.length()];
        for(int i = 0; i < list.length; i++){
            list[i] = str.charAt(i) - '0';
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = list.length - 1; i >= 0; i--){
            sb.append(list[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}