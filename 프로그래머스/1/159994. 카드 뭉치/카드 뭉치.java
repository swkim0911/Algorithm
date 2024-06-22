class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int cur1 = 0;
        int cur2 = 0;
        for(String str : goal){
            if(cur1 < cards1.length && cards1[cur1].equals(str)){
                cur1++;
            }else if(cur2 < cards2.length && cards2[cur2].equals(str)){
                cur2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}