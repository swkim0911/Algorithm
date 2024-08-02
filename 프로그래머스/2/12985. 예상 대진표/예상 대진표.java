class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            answer++;
            if(check(a,b)) break;
            a = (a+1) / 2;
            b = (b+1) / 2;
        }

        return answer;
    }
    
    public boolean check(int a, int b){
        if(a < b){
            if(a % 2 == 1 && b == a + 1) return true;
        }else{
            if(b % 2 == 1 && a == b + 1) return true;
        }
        return false;
    }
}

