import java.io.*;

class Solution
{
    static char[] number;
    static int max, chance;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int t = 1; t <= n; t++){
            String[] split = br.readLine().split(" ");
            number = split[0].toCharArray();
            chance = Integer.parseInt(split[1]);
            max = 0;
            if (number.length < chance) {
                chance = number.length;
            }
            dfs(0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == chance) {
            StringBuilder result = new StringBuilder();
            for (char c : number) {
                result.append(c);
            }
            max = Math.max(max, Integer.parseInt(result.toString()));
            return;
        }
        for (int i = start; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                //swap
                char tmp = number[i];
                number[i] = number[j];
                number[j] = tmp;
                dfs(i, cnt + 1);
                tmp = number[i];
                number[i] = number[j];
                number[j] = tmp;
            }
        }
    }
}
