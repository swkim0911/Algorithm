class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') p++;
            if(c == 'y' || c == 'Y') y++;
        }
        if(p != y) return false;
        else return true;
        
    }
}