
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
		public static void main(String[] arges) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= testcase; t++){
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 10; i++) {
				int val = Integer.parseInt(st.nextToken());
				if(val % 2 == 1) {
					ans += val;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}

