class Solution {
    public String solution(int n) {
        String str = "수박";
        if(n % 2 == 0){
            return str.repeat(n/2);
        }else{
            return str.repeat(n/2) + "수";
        }        
    }
}