import java.util.*;


class Solution {

    String[] alphabet = {"A", "E", "I", "O", "U"};
    Set<String> set = new HashSet<>();

    public int solution(String word) {
        int answer = 0;
        func(0, "");
        List<String> list = new ArrayList<>(set);
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
        if(cnt == 5){
            set.add(word);
            System.out.println(word);
            return;
        }
        func(cnt+1, word);

        for(int i = 0; i < alphabet.length; i++){
            func(cnt+1, word+alphabet[i]);
        }
    }
}