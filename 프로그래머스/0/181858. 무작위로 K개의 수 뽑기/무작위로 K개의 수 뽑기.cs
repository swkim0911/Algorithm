using System.Collections.Generic;
using System.Linq;
using System;

public class Solution {
    public int[] solution(int[] arr, int k) {
        HashSet<int> set = new HashSet<int>();
        int count = 0;
        foreach(var v in arr){
            if(!set.Contains(v) && count < k){
                set.Add(v);
                count += 1;
            }
        }
        var answer = new List<int>(set);
        if(count != k){
            for(int i = 0; i < k - count; i++){
                answer.Add(-1);
            }
        }
        return answer.ToArray();
    }
}