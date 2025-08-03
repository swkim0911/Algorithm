import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        // 1. ioi 쌍의 위치 저장. 3 * 100만
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i <= m - 3; i++) {
            if ("IOI".equals(s.substring(i, i + 3))) {
                if (i % 2 == 0) {
                    even.add(i);
                }else{
                    odd.add(i);
                }
            }
        }
        // 2. [2,4,6,9] // 3 -> 1, 5 -> 2 7 -> 3 : 2n+1 -> n  : 2차이 나는 수가 n개 연속 있으면 문자열을 만들 수 있다.
        // 짝수, 홀수 따로
        int answer = 0;
        for (int i = 0; i < even.size() - (n - 1); i++) {
            if (even.get(i + (n - 1)) == even.get(i) + (n - 1) * 2) {
                answer += 1;
            }
        }

        for (int i = 0; i < odd.size() - (n - 1); i++) {
            if (odd.get(i + (n - 1)) == odd.get(i) + (n - 1) * 2) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}




