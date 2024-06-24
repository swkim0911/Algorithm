class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        for(int i = 2; i < arr.length; i++){
            // 나 빼고 나머지 true
            for(int j = i*2; j < n+1; j += i){
                arr[j] = true;
            }
        }
        for(int i = 2; i < arr.length; i++){
            if(!arr[i]) answer++;
        }
        
        return answer;
    }
}

    