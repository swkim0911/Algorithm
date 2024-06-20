class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i = food.length - 1; i >= 1; i--){
            int times = food[i] / 2;
            if(times > 0){
                answer += String.valueOf(i).repeat(times);
                answer = String.valueOf(i).repeat(times) + answer;
            }
        }
        return answer;
    }
}