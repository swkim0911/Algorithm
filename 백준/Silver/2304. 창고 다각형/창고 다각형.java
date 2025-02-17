import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0; // 최고 높이

        ArrayList<Pillar> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int l = Integer.parseInt(split[0]);
            int h = Integer.parseInt(split[1]);
            max = Math.max(max, h);
            list.add(new Pillar(l, h));
        }
        Collections.sort(list, (o1, o2) -> o1.l - o2.l);
        int sum = 0;

        Pillar before = null;
        int leftIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            Pillar cur = list.get(i);
            if(cur.h == max){
                if(before != null){ // 높은 기둥이 중간에 있는 경우
                    sum += (cur.l - before.l) * before.h;
                }
                leftIdx = i;
                break;
            }
            if(i == 0){
                before = cur;
            }else{
                if (cur.h >= before.h) {
                    sum += (cur.l - before.l) * before.h;
                    before = cur;
                }
            }
        }
        before = null;
        int rightIdx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Pillar cur = list.get(i);
            if(cur.h == max){
                if(before != null){
                    sum += (before.l - cur.l) * before.h;
                }
                rightIdx = i;
                break;
            }
            if(i == list.size() - 1){
                before = cur;
            }else{
                if(cur.h >= before.h){
                    sum += (before.l - cur.l) * before.h;
                    before = cur;
                }
            }
        }
        sum += ((list.get(rightIdx).l+1) - list.get(leftIdx).l) * max;
        System.out.println(sum);


    }
    // 0. 위치 별로 정렬하기
    // 1. 최고 위치 찾기
    // 2. 최고 위치 기준으로 양 옆에서 상승하게
    // 3. 합을 더하는 것도 양옆에서 더하기. 마지막 + 최고높이 기둥(들)의 넓이
}

class Pillar{
    int l;
    int h;

    public Pillar(int l, int h) {
        this.l = l;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Pillar{" +
                "l=" + l +
                ", h=" + h +
                '}';
    }
}



