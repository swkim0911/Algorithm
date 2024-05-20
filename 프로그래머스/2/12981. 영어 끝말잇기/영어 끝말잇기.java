import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        Set<String> set = new HashSet<>();
        String before = words[0];
        set.add(words[0]);
        // 0,1,2,3,4,5,6,7,8,9
        for (int i = 1; i < words.length; i++) {

            if (set.contains(words[i]) || before.charAt(before.length() - 1) != words[i].charAt(0)) {
                int time = (i / n) + 1;
                int number = (i % n) + 1;
                answer = new int[]{number, time};
                break;
            }
            before = words[i];
            set.add(words[i]);
        }

        return answer;
    }

}