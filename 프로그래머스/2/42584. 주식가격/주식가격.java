import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stack에 남아있는 index들은 아직 가격이 떨어지지 않은 곳을 만나지 못했다.
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ // i 번째에서 가격이 떨어지는 순간
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }
        
        while(!stack.isEmpty()){ // prices 배열을 끝까지 봤을 때 떨어지는 순간을 만나지 못해 stack에 남아있는 경우
            answer[stack.peek()] = n - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}