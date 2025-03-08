import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] maxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        maxs = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            backTracking(i, arr, 0, 0, 0);
        }
        int answer = 0;
        int mmax = 0;
        for (int i = 0; i < n; i++) {
            if(mmax <= maxs[i]){
                answer = i+1;
                mmax = maxs[i];
            }
        }
        System.out.println(answer);
    }

    /**
     *
     * @param num 사람 번호
     * @param arr 카드 배열
     * @param cur 현재 뽑은 카드 개수
     * @param s 시작 위치
     * @param sum 총 합
     */
    public static void backTracking(int num, int[] arr, int cur, int s, int sum) {
        if(cur == 3){
            maxs[num] = Math.max(maxs[num], sum % 10);
            return;
        }
        for (int i = s; i < 5; i++) {
            backTracking(num, arr, cur + 1, i + 1, sum + arr[i]);
        }
    }
}
