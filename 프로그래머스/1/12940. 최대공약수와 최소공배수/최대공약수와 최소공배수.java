class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = n > m ? getGcd(n,m) : getGcd(m,n);
        int[] answer = {gcd, n*m / gcd};
        
        
        return answer;
    }
    
    // 최대공약수 (a > b)
    public int getGcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}