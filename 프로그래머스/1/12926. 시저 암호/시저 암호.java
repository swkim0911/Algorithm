class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append(c);
                continue;
            }
            char tmp = (char)(c + n);
                if(c >= 'a' && c <= 'z'){
                    if(tmp > 'z'){
                        tmp = (char)('a' + tmp - 'z' - 1);
                    }
                }else if(c >= 'A' && c <= 'Z'){
                    if(tmp > 'Z'){
                        tmp = (char)('A' + tmp - 'Z' - 1);
                    }
                }
            sb.append(tmp);
        }
        return sb.toString();
    }
}