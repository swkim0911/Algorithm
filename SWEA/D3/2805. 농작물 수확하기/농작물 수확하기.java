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
            int start = n/2;
            int end = n/2;
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = start; j <= end; j++) {
                    sum += line.charAt(j) - '0';
                }
                if (i < n / 2) {
                    start--;
                    end++;
                }else{
                    start++;
                    end--;
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
