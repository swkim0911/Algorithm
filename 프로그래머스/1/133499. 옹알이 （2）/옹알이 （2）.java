class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String input : babbling){
            if(input.contains("ayaaya") ||input.contains("yeye") || input.contains("woowoo") || input.contains("mama")) continue;
            input = input.replace("aya", " ");
            input = input.replace("ye", " ");
            input = input.replace("woo", " ");
            input = input.replace("ma"," ");
            input = input.replace(" ", "");
            
            if(input.equals("")) answer++;
        }
        return answer;
    }
}