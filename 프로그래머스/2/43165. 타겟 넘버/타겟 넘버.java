class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public int dfs(int[] numbers, int depth, int cur, int target){
        int total = 0;
        if(depth == numbers.length){
            if(cur == target){
                return 1;
            }
            return 0;
        }
        total += dfs(numbers, depth + 1, cur + numbers[depth], target);
        total += dfs(numbers, depth + 1, cur - numbers[depth], target);
        
        return total;
        
    }
}

// 시간 복잡도: 최대 O(2^20(숫자 개수))