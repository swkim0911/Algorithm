import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> o2.cnt - o1.cnt);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Info(entry.getKey(), entry.getValue()));
        }
        int answer = 0;
        while(true){
            Info info = pq.poll();
            answer++;
            if(k - info.cnt <= 0) break;
            k -= info.cnt;
        }
        
        return answer;
    }
}

class Info{
    int size;
    int cnt;
    
    public Info(int size, int cnt){
        this.size = size;
        this.cnt = cnt;
    }
}
