class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int cnt, int val, int[] numbers, int target){
        if(cnt == numbers.length){
            if(val == target) answer++;
            return;
        }
        dfs(cnt + 1, val + numbers[cnt], numbers, target);
        dfs(cnt + 1, val - numbers[cnt], numbers, target);
    }
}