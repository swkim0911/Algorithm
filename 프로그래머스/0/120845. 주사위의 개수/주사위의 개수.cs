using System;

public class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        foreach(int len in box){
            answer *= (len / n); 
        }
        return answer;
    }
}
