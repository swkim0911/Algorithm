import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[101]; // 0 ~ 100 점
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                arr[score]++;
            }
            int idx = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] >= max){
                    idx = i;
                    max = arr[i];
                }
            }
            sb.append("#").append(t).append(" ").append(idx).append("\n");
        }
        System.out.println(sb);
    }
}

