import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    static int n;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            result.clear();
            dfs(1, "1");
            Collections.sort(result);
            result.forEach(s -> sb.append(s).append("\n"));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int depth, String expression) {
        if (depth == n) {
            if (evaluate(expression.replace(" ", "")) == 0) {
                result.add(expression);
            }
            return;
        }
        int next = depth + 1;
        dfs(next, expression + " " + next);
        dfs(next, expression + "+" + next);
        dfs(next, expression + "-" + next);
    }
    // 12 - 34
    private static int evaluate(String expr) {
        int sum = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < expr.length(); ) {
            int j = i;
            while (j < expr.length() && Character.isDigit(expr.charAt(j))) {
                j++;
            }
            num = Integer.parseInt(expr.substring(i, j));
            if (sign == '+') {
                sum += num;
            }else if(sign == '-') sum -= num;
            if(j < expr.length()) sign = expr.charAt(j);
            i = j + 1;
        }

        return sum;
    }
}