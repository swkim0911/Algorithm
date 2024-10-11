class Solution {
    public int solution(int[] people, int limit) {
        // init
        int answer = 0;
        int[] weights = new int[241]; //weights[x]: 몸무게가 x인 사람수 (x: 40kg ~ 240kg)
        for(int p : people){
            weights[p] += 1; // 몸무게 p인 사람 + 1
        }
        for(int i = 0; i <= 240; i++){
            while(weights[i] > 0){
                weights[i]--;
                answer++; 
                for(int j = limit - i; j >= 0; j--){
                    if(weights[j] > 0){ // limit 안으로 두명이 탈 수 있을 경우
                        weights[j]--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}