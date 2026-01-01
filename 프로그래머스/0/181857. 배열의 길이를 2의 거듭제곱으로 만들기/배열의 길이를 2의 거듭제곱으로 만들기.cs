using System;

public class Solution {
    public int[] solution(int[] arr) {
        int len = arr.Length;
        int val = 1;
        while(len > val){
            val *= 2;
        }
        
        int[] answer = new int[val];
        for(int i = 0; i < len; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}