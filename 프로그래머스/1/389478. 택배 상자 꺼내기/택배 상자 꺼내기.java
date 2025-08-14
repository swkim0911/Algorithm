class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int r = (num - 1) / w; // num의 x좌표
        int c = (r % 2 == 0 ? (num - 1) % w : (w - 1) - ((num - 1) % w)); // num의 y좌표
        for(; r < (n + (w-1)) / w; r++){
            int cur = (w * r) + (r % 2 == 0 ? (c + 1) : (w + 1) - (c + 1));
            if(cur <= n){
                answer += 1;
            }
        }
        
        return answer;
    }
}

// 수학으로 풀기
// 1. num의 위치 r,c 을 찾고
// 2. 그 위에 수들을 직접 찾아보면서 개수 찾기. 단, <= n 

// 1. w의 위치
// r = (num - 1) / w
// c = r % 2 == 0 ? (num - 1) % w : (w - 1) - (num - 1) % w

