using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] arr) {
        var answer = new List<int>();
        for(int i = 0; i < arr.Length; i++){
            if(answer.Count == 0){
                answer.Add(arr[i]);
            }else{
                if(answer[answer.Count - 1] == arr[i]){
                    answer.RemoveAt(answer.Count - 1);
                }else{
                    answer.Add(arr[i]);
                }
            }
        }
        return answer.Count == 0 ? new int[]{-1} : answer.ToArray();
    }
}