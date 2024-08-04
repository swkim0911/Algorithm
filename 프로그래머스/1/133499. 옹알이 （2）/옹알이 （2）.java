class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String input : babbling){
            int before = -1;
            boolean flag = false;
            while(true){
                flag = false;
                for(int i = 0; i < words.length; i++){
                    String word = words[i];
                    if(input.length() >= word.length()){
                        if(word.equals(input.substring(0, word.length()))){
                            if(before != i){
                                before = i;
                                input = input.substring(word.length());
                                flag = true;   
                            }
                            break;
                        }
                    }
                }
                if(!flag) break;
            }
            if(input.equals("")) answer++;
        }
        return answer;
    }
}