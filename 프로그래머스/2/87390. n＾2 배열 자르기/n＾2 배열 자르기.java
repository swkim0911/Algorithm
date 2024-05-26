import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(long i = left; i <= right; i++){
            int r = (int)(i / n + 1);
            int c = (int)(i % n + 1);
            list.add(Math.max(r,c));
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

/**
1 2 3 4 
2 2 3 4 
3 3 3 4 
4 4 4 4 

1 2 3 2 2 3 3 3 3


**/