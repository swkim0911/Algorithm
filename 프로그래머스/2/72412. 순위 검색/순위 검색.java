import java.util.*;

class Solution {
    
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] infos, String[] query) {
        
        // 1. infos 값들을 hashMap에 저장
        for(String info : infos){
            func(info.split(" "));
        }
        
        // 2. 각 hashMap에 value 들을 오름차순으로 정렬
        for(ArrayList<Integer> list : map.values()){
            list.sort((o1,o2) -> o1 - o2);
        }
        // 3. 각 query에 맞는 지원자를 찾는다.
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String q = query[i];
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);
            int cnt = 0;
            
            if(map.containsKey(key)){
                ArrayList<Integer> list = map.get(key);
                cnt = binarySearch(list, target);
            }
            answer[i] = cnt;
        }
        
        
        return answer;
    }
    
    // 이진 탐색 1 2 3 4
    public int binarySearch(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return list.size() - left;
    }
    // 백트래킹을 이용해서 2^4 경우를 map에 저장  
    public void dfs(String[] split, String result, int depth){
        if(depth == 4){
            int score = Integer.parseInt(split[depth]);
            map.computeIfAbsent(result.trim(), k -> new ArrayList<>()).add(score);
        }
        dfs(split, result + split[depth] + " ", depth + 1);
        dfs(split, result + "- ", depth + 1);
    }
    // 2진수를 활용해서 2^4 경우를 map에 저장  
    public void func(String[] split){

        int score = Integer.parseInt(split[4]);
        for(int i = 0; i < (1 << 4); i++){
            String result = "";
            int cur = i;
            for(int j = 0; j < 4; j++){
                int rest = cur % 2;
                if(rest == 0) result += split[j] + " ";
                else result += "- ";
                cur = cur / 2;
            }
            result = result.trim();
            map.computeIfAbsent(result, k -> new ArrayList<>()).add(score);
        }
    }
}

// 쿼리 조건에 맞는 data를 찾는 거

// n: 5만, m:10만
// 브루트포스: n*m = 50억
// hashmap + 이분탐색
// 1. hashMap 에 데이터 저장.
// 2. 각 hashMap value들 정렬. 원소의 최대 개수가 2^13 이니 