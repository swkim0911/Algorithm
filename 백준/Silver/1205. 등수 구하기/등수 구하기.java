import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 현재 크기
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 제한된 크기
        int[] scores = new int[p + 1]; // ranks[x]: x등수의 점수
        int answer = 0;
        if(n != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                if(i == n-1){
                    if(n == p){
                        if(score > scores[i+1]){ // 만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
                            answer = i+1;
                            for (int j = i; j >= 0; j--) {
                                if(score != scores[j]) break;
                                answer--;
                            }
                        }else{
                            answer = -1;
                        }
                    }else{
                        if(score >= scores[i+1]){
                            answer = i+1;
                        }else{
                            answer = i+2;
                        }
                    }
                    break;
                }else{
                    if(n == p){
                        if(score > scores[i+1]){
                            // 뒤에 나랑 같은 애 있는지 보기
                            answer = i+1;
                            for (int j = i; j >= 0; j--) {
                                if(score != scores[j]) break;
                                answer--;
                            }
                            break;
                        }
                    }else{
                        if(score >= scores[i+1]){
                            answer = i+1;
                            break;
                        }
                    }
                }
            }
        }else{ // n == 0 이면 항상 1
            answer = 1;
        }
        System.out.println(answer);

    }
}
