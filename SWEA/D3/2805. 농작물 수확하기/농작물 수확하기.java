import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i <= n/2; i++) {
                String line = br.readLine();
                for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                    sum += line.charAt(j) - '0';
                }
            }
            for (int i = n / 2 + 1; i < n; i++) {
                String line = br.readLine();
                for (int j = i - n / 2; j < n - i + n/2; j++) {
                    sum += line.charAt(j) - '0';
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/**
 * 0 1 2 3 4
 *
 * 2 1 0 1 2
 * 2 3 4 3 2
 *
 * 0 1 2 3 4 5 6
 *
 * 3 2 1 0 1 2 3
 * 3 4 5 6 5 4 3
 */
/**
 * n - i + n/2
 */