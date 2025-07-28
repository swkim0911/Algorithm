import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            String[] split = option.split(" ");
            // 1
            boolean first = false;
            for (int j = 0; j < split.length; j++) {
                char c = Character.toLowerCase(split[j].charAt(0));
                if (!set.contains(c)) {
                    set.add(c);
                    split[j] = "[" + split[j].charAt(0) + "]" + split[j].substring(1);
                    sb.append(String.join(" ", split)).append("\n");
                    first = true;
                    break;
                }
            }
            boolean second = false;
            if (!first) {
                for (int j = 0; j < option.length(); j++) {
                    char c = Character.toLowerCase(option.charAt(j));
                    if(c == ' ') continue;
                    if (!set.contains(c)) {
                        set.add(c);
                        sb.append(option.substring(0, j) + "[" + option.charAt(j) + "]" + option.substring(j + 1)).append("\n");
                        second = true;
                        break;
                    }
                }
            }
            if (!first && !second) {
                sb.append(option).append("\n");
            }
        }
        System.out.println(sb);
    }
}
