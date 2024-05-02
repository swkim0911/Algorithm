
import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
                answer += arr[i] > max ? arr[i] - max : 0;
            }
            sb.append("#" + test_case + " " + answer).append("\n");
        }
        System.out.println(sb);
    }
}