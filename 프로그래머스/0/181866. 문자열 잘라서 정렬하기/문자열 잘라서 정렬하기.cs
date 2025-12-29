using System;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string myString) {
        
        string[] parts = myString.Split('x');
        List<string> answer = new List<string>();
        
        foreach (string s in parts){
            if(s != ""){
                answer.Add(s);
            }
        }
        answer.Sort();
        
        return answer.ToArray();
    }
}