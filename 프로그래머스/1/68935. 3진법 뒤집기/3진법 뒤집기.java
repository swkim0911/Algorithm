class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        int div = n;
        while(div != 0){
            int rest = div % 3;
            str = rest + str;
            div /= 3;
        }
        for(int i = 0; i < str.length(); i++){
            int mul = 1;
            for(int j = 0; j < i; j++){
                mul *= 3;
            }
            answer += mul*(str.charAt(i) - '0');
        }
        
        return answer;
    }
}