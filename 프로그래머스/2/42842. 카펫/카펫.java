import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int r = 3;
        while(true){
            int l;
            if(total % r == 0){
                l = total / r;
                if(brown == 2*(r+l) - 4 && yellow == (r-2) * (l-2) && r >= l){
                    answer[0] = r;
                    answer[1] = l;
                    break;
                }
            }
            r++;
        }
        return answer;
    }
}



/**
 * b b b b b b b b
 * b
 * b
 * b
 * b
 * b b b b b b b b
 * (r >= l)
 * r*l = brown + yellow (r>2, l > 2)
 * brown = 2*r + 2*(l - 2) = 2*(r+l) - 4
 * yellow = (r-2) * (l-2)
 */