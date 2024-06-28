class Solution {
    public int solution(int n) {
        int targetCnt = Integer.bitCount(n);
        int answer = n+1;
        while(true){
            int oneCnt = Integer.bitCount(answer);
            if(oneCnt == targetCnt){
                break;
            }
            answer++;
        }
        return answer;
    }
}