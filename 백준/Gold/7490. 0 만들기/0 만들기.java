import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static char[] opArr = {'+', '-', ' '};
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(n, new ArrayList<>());
            list.sort(String::compareTo);
            list.forEach(s -> sb.append(s).append("\n"));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int n, ArrayList<Character> ops) {
        if (ops.size() == n - 1) {
            String expression = "1";
            int next = 2;
            for (Character c : ops) {
                expression += c + String.valueOf(next);
                next += 1;
            }
            int result = calc(expression);
            if(result == 0){
                list.add(expression);
            }
            return;
        }
        // +, -, ' '
        for (int i = 0; i < 3; i++) {
            ops.add(opArr[i]);
            dfs(n, ops);
            ops.remove(ops.size() - 1);
        }

    }

    private static int calc(String str) {
        str = str.replace(" ", ""); // 공백지우기
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <='9') {
                tmp += c;
            } else {
                numbers.add(Integer.parseInt(tmp));
                tmp = "";
                ops.add(c);
            }
        }

        numbers.add(Integer.parseInt(tmp));

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Character op = ops.get(i - 1);
            Integer number = numbers.get(i);
            if (op == '+') {
                result += number;
            } else if (op == '-') {
                result -= number;
            }
        }
        return result;
    }
}
