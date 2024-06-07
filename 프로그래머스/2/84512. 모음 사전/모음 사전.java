import java.util.*;


class Solution {

    String[] alphabet = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        func(0, ""); // list에 // "" 도 포함됨
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void func(int cnt, String word){
        list.add(word);
        if(cnt == 5) return;

        for(int i = 0; i < alphabet.length; i++){
            func(cnt+1, word+alphabet[i]);
        }
    }
}