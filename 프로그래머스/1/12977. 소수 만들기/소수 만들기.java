class Solution {
    
    int answer = 0;
    
    
    public int solution(int[] nums) {
    
        dfs(nums, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] nums, int cnt, int sum, int cur){
        if(cnt == 3){
            if(isPrime(sum)) answer++;
            return;
        }
        
        for(int i = cur; i < nums.length; i++){
            dfs(nums, cnt + 1, sum + nums[i], i + 1);
        }
    }
    
    public boolean isPrime(int number){
        for(int i = 2; i < number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}