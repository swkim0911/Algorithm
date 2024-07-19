import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < X.length(); i++){
            char c = X.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < Y.length(); i++){
            char c = Y.charAt(i);
            if(map.containsKey(c)){
                Integer key = map.get(c);
                if(key > 0){
                    map.replace(c, key - 1);
                    list.add(c - '0');
                }
            }
        }
        if(list.size() == 0) return "-1";
        int cnt = 0;
        for(int i : list){
            if(i == 0) cnt++;
        }
        if(cnt == list.size()) return "0";
        Collections.sort(list, (o1,o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append(i);
        }
        return sb.toString();
    }
}