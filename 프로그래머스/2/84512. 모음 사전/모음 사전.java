import java.util.*;

class Solution {
    
    ArrayList<String> list = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    String[] alphabet = {"", "A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        dfs(0,"");
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
    
    public void dfs(int depth, String str){
        if(depth == 5){
            if(!set.contains(str) && !str.isEmpty()){
                set.add(str);
                list.add(str);            
            }
            return;
        }
        for(int i = 0; i < alphabet.length; i++){
            dfs(depth + 1, str + alphabet[i]);
        }
    }
}

// "" A AA AAA AAAA AAAAA AE AEA AEAA AEAAA

// 6^5