class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cursor = 0; // 페인트칠 한 마지막 위치
        for(int number : section){
            if(cursor < number){
                cursor = number + m - 1; // number ~ number + m 범위까지 페인트 칠
                answer++;
            }
        }
        
        return answer;
    }
}