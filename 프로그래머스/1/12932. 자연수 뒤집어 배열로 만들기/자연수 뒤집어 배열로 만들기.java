class Solution {
    public int[] solution(long n) {
        String val = String.valueOf(n);
        int[] answer = new int[val.length()];
        for(int i = 0; i < val.length(); i++){
            answer[answer.length-(i+1)] = val.charAt(i) - '0';
        }
        return answer;
    }
}