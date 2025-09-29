import java.util.*;

class Solution {
    
    int answer = 0;
    Character[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] datas) {
        dfs(0, new StringBuilder(), datas, new boolean[8]);
        return answer;
    }
    // ABCDE
    
    public void dfs(int cur, StringBuilder sb, String[] datas, boolean[] visited){
        if(cur == 8){
            for(String condition : datas){
                boolean isOk = checkCondition(sb.toString(), condition);
                if(!isOk) return;
            }
            answer += 1;
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(visited[i]) continue;
            visited[i] = true;
            StringBuilder tmp = new StringBuilder(sb.toString());
            dfs(cur + 1, tmp.append(friends[i]), datas, visited);
            visited[i] = false;
        }
        
    }
    
    public boolean checkCondition(String str, String condition){
        HashMap<Character, Integer> map = new HashMap<>(); // <문자, 위치>
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), i);
        }
        char from = condition.charAt(0);
        char to = condition.charAt(2);
        char ops = condition.charAt(3);
        int gap = condition.charAt(4) - '0';
        
        
        int realGap = Math.abs(map.get(from) - map.get(to)) - 1;
        if(ops == '='){
            if(realGap == gap) return true;
        }else if(ops == '<'){
            if(realGap < gap) return true;
        }else if(ops == '>'){
            if(realGap > gap) return true;
        }
        
        return false;
    }
    
}

// 전체 8! * (100* 8)
// 첫조건 7! * 2