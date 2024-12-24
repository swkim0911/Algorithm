import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int cur = 0;
        String[] target = {"KBS1", "KBS2"};
        int t = 0;
        boolean find = false;
        while(!(arr[0].equals("KBS1") && arr[1].equals("KBS2"))){
            if(!find){ // 아직 찾지 못했으면 쭉 내려가기
                if (arr[cur].equals(target[t])) {
                    find = true;
                } else {
                    cur += 1;
                    sb.append(1);
                }
            }else{
                if(cur == t){
                    find = false;
                    t += 1;
                }else{
                    //swap
                    String tmp = arr[cur];
                    arr[cur] = arr[cur-1];
                    arr[cur-1] = tmp;
                    cur -= 1;
                    sb.append(4);
                }
            }

        }
        System.out.println(sb);
    }
}