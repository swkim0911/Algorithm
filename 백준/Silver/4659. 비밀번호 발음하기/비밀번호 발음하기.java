import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] vowels = {"a","e","i","o","u"};
        while(true){
            String input = br.readLine();
            if(input.equals("end")) break;
            boolean isOk = false;
            for (int i = 0; i < 5; i++) {
                if(input.contains(vowels[i])){ // 하나라도 포함
                    isOk = true;
                    break;
                }
            }

            // 세개 연속 check
            for(int i = 0; i <= input.length() - 3; i++) {
                char c = input.charAt(i);
                if (isVowel(c)){
                    if(isVowel(input.charAt(i+1)) && isVowel(input.charAt(i+2))){
                        isOk = false;
                        break;
                    }
                }else{
                    if(!isVowel(input.charAt(i+1)) && !isVowel(input.charAt(i+2))){
                        isOk = false;
                        break;
                    }
                }
            }

            for(int i = 0; i <= input.length() - 2; i++){
                char c = input.charAt(i);
                if(c == 'e' || c == 'o') continue;
                if(c == input.charAt(i+1)){ // 연속된 경우
                    isOk = false;
                    break;
                }
            }


            if(isOk){
                sb.append("<").append(input).append("> is acceptable.");
            }else{
                sb.append("<").append(input).append("> is not acceptable.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}