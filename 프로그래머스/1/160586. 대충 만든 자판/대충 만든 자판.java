class Solution {
    public int[] solution(String[] keymaps, String[] targets) {
        int[] answer = new int[targets.length];
        label : for(int i = 0; i < targets.length; i++){
            for(char c1 : targets[i].toCharArray()){
                int min = 101;
                for(String keymap : keymaps){
                    for(int j = 0; j < keymap.length(); j++){
                        char c2 = keymap.charAt(j);
                        if(c1 == c2){
                            min = Math.min(min, j+1);
                            break;
                        }
                    }  
                }
                if(min == 101){
                    answer[i] = -1;
                    continue label;
                }else{
                    answer[i] += min;
                }
            }
            
            
        }
        return answer;
    }
}