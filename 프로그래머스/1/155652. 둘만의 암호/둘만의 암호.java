class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int times = index;
            while(times-- > 0){
                c = c + 1 > 'z' ? 'a' : (char)(c+1);
                if(skip.contains(String.valueOf(c))){
                    times++;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}