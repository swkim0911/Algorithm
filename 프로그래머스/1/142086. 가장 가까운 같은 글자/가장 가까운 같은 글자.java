import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr = s.split("");
        int[] answer = new int[s.length()];
        int i = 0;
        for(String str : arr){
            if(map.containsKey(str)){
                answer[i] = i - map.get(str);
                map.replace(str, i);
            }else{
                map.put(str, i);
                answer[i] = -1;
            }
            i++;
        }
        return answer;
    }
}