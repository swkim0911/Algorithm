import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Info[] arr = new Info[n * 2 + 1]; // qye
        for (int i = 1; i <= 2 * n; i++) {
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new Info(d);
        }
        int time = 0;
        while(true){
            time += 1;
            // 1. 회전 이동
            Info last = arr[2 * n]; // 마지막 요소 저장

            for (int i = 2 * n; i >= 2; i--) {
                arr[i] = arr[i - 1];
            }
            arr[1] = last;
            if(arr[n].robot){
                arr[n].robot = false;
            }

            // 2. 가장 먼저 벨트에 올라간 로봇부터 이동.
            for (int i = n - 1; i >= 1; i--) {
                if (arr[i].robot && !arr[i+1].robot && arr[i+1].durability > 0) {
                    arr[i+1].robot = true;
                    arr[i].robot = false;
                    arr[i+1].durability -= 1;
                    if(i+1 == n){
                        arr[i+1].robot = false;
                    }
                }
            }
            // 3. 올리는 위치에 내구도가 0이 아니면 로봇을 올림
            if(arr[1].durability != 0){
                arr[1].robot = true;
                arr[1].durability -= 1;
            }

            // 4. 내구도가 0인 카의 개수가 k개 이상이면 끝.
            int total = 0;
            for (int i = 1; i <= 2 * n; i++) {
                if(arr[i].durability == 0){
                    total += 1;
                }
            }
//            for (int i = 1; i <= 2 * n; i++) {
//                System.out.print(arr[i].durability+" ");
//            }
//            System.out.println();
            if(total >= k) break;
        }

        System.out.println(time);

    }
}

class Info {
    int durability;
    boolean robot;

    public Info(int durability) {
        this.durability = durability;
        this.robot = false;
    }

}
// 1 2 1 2 1 2
// 1번 칸: 올리는 위치
// 3번 칸: 내리는 위치

// 1.
// 1 1 2 1 2 1

// 2.
// 0 1 0 2 1 2


