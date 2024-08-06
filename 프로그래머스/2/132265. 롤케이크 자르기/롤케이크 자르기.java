import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        //init
        for(int toppin : topping){
            map2.put(toppin, map2.getOrDefault(toppin, 0) + 1);
        }
        for(int toppin : topping){
            map1.put(toppin, map1.getOrDefault(toppin, 0) + 1);
            if(map2.get(toppin) == 1){
                map2.remove(toppin);
            }else{
                map2.replace(toppin, map2.get(toppin) - 1);
            }
            if(map1.keySet().size() == map2.keySet().size()) answer++;
        }
        return answer;
    }
}