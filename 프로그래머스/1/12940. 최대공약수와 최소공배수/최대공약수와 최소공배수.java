class Solution {
    public int[] solution(int n, int m) {
        int min = Math.min(n,m);
        int ans1 = 0;
        for(int i = 1; i <= min; i++){
            if(n%i == 0 && m%i == 0) ans1 = i;
        }
        int ans2 = ans1 * (n / ans1) * (m / ans1);
        int[] answer = new int[]{ans1,ans2};
        
        return answer;
    }
}