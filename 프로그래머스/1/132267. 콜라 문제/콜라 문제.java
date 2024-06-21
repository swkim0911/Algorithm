class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int rest = n % a;
            int div = n / a;
            answer += div * b;
            n = rest + div * b;
        }
        return answer;
    }
}