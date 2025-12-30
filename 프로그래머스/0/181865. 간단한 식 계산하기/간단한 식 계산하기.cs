using System;

public class Solution {
    public int solution(string binomial) {
        string[] split = binomial.Split(" ");
        int a = Int32.Parse(split[0]);
        string op = split[1];
        int b = Int32.Parse(split[2]);
        
        int answer = 0;
        if(op.Equals("+")){
            answer = a + b;
        }else if(op.Equals("-")){
            answer = a - b;
        }else{
            answer = a * b;
        }
        
        return answer;
    }
}