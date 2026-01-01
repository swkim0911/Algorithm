using System;
using System.Linq;

public class Solution {
    public int solution(string[] strArr) {
        int answer = 0;
        int[] lengthArr = new int[31];
        foreach(string str in strArr){
            lengthArr[str.Length] += 1;
        }
        
        return lengthArr.Max();
    }
}