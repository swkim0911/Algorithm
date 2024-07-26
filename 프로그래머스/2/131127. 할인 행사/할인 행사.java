import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        label : for(int s = 0; s < discount.length - 9; s++){
            Map<String, Integer> tmp = new HashMap<>();
            for(int i = 0; i < 10; i++){
                tmp.put(discount[s+i], tmp.getOrDefault(discount[s+i], 0) + 1);
            }
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                String key = entry.getKey();
                if(!tmp.containsKey(key) || tmp.get(key) < entry.getValue()) continue label;
            }
            answer++;
        }
        return answer;
    }
}