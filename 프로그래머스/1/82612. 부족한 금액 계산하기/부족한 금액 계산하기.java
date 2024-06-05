class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0L;
        for(int i = 0; i < count; i++){
            sum += (long)(i + 1) * price;
        }
        if(money >= sum){
            return 0L;
        }
        return sum - (long)money;
    }
}