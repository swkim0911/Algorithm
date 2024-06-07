import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        label :for(String skillTree : skill_trees){
            int cursor = 0; // 0 ~ skill.lengh - 1
            for(int i = 0; i < skillTree.length(); i++){
                char c = skillTree.charAt(i);
                if(skill.contains(String.valueOf(c))){
                    if(skill.charAt(cursor) != c) continue label;
                    else cursor++;
                }
            }
            answer++;
        }
        return answer;
    }
}