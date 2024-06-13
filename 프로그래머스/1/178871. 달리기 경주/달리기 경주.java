import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for(String calling : callings){
            Integer cur = map.get(calling);
            String prevname = players[cur-1];
            players[cur-1] = calling;
            players[cur] = prevname;
            map.replace(calling, cur-1);
            map.replace(prevname, cur);
        }
        
        return players;
    }
}

/**
해시 맵. <이름, 번호>
0. players 배열
1. 해시 맵을 통해 이름을 검색해서 번호를 찾기.
2. player 배열에서 그 번호와 앞 번호와 변경하기.
3. 해시 맵 갱신하기.
*/
