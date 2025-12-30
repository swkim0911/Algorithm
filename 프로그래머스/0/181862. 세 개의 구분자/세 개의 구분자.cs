using System;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string myStr) {
        string[] split1 = myStr.Split("a");
        List<string> answer = new List<string>();
        foreach(string str1 in split1){
            string[] split2 = str1.Split("b");
            foreach(string str2 in split2){
                string[] split3 = str2.Split("c");
                foreach(string word in split3){
                    if(!word.Equals("")){
                        answer.Add(word);
                    }
                }
            }
        }
        if(answer.Count == 0){
            answer.Add("EMPTY");
        }
        
        return answer.ToArray();
    }
}