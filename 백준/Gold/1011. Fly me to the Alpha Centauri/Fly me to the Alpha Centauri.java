import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int left = 0; // arr 왼쪽 idx
            int right = y-x; // arr 오른쪽 idx
            int answer = 0;
            int time = 0;
            while(left < right){
                if(time != 0){
                    answer += 2;
                }
                time++;
                left += time;
                right -= time;
            }
            left -= time;
            right += time;
            time -= 1;
            if(right - left <= time + 1){
                answer++;
            }else{
                answer += 2;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
/**
 * 0 3
 * 0 1 2 3
 *
 * 1 5
 * 1 2 3 4 5
 *  1
 *
 * 0 9
 * 0 1 2 3 4 5 6 7 8 9 10
 *
 *
 * 1 2
 *   2 1
 */

// 1. 배열에서 넘어가는 타이밍 찾기
// 2. 넘어가기 바로 직전에서 left 와 right
// 3.1 left = right 이면 현재까지 건너간 횟수만큼
// 3.2 아닐 때 left에서 +1 이나 + 0 으로 넘어 올 수 있는지 확인.
// 4.1 가능하면 횟수 + 1
// 4.2 가능하지 않으면 + 2
