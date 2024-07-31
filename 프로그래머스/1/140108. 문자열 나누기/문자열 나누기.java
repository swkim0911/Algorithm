class Solution {
    public int solution(String s) {
        int answer = 0;
        int cursor = 0;
        for(int i = 0; i < s.length(); i = cursor + 1){
            char c = s.charAt(i);
            int xCnt = 1;
            int yCnt = 0;
            cursor = i+1;
            while(true){
                if(cursor >= s.length()){
                    answer++;
                    break;
                }
                char nxt = s.charAt(cursor);
                if(nxt != c){
                    yCnt++;
                }else{
                    xCnt++;
                }
                if(xCnt == yCnt){
                    answer++;
                    break;
                }
                cursor++;
            }
            
        }
        return answer;
    }
}