import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Room> list = new ArrayList<>(); // 모든 방을 돌면서 레벨안에 들어가는지 확인해야 함.
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Member member = new Member(lv, name);
            // 매칭이 가능한 방이 없으면 새로운 방 생성
            label : if(!list.isEmpty()){
                for (Room room : list) {
                    if(room.isOk(member) && !room.isFull()){ // 범위안에 들어가고 정원이 차지 않았을 때
                        room.addMember(member);
                        break label;
                    }
                }
                list.add(new Room(member, m)); // 모든 방을 봤을 때 들어갈 수 없는 경우
            }else{
                list.add(new Room(member, m)); // 방이 없는 경우
            }
        }
        for (Room room : list) {
            if (room.isFull()) {
                sb.append("Started!");
            }else{
                sb.append("Waiting!");
            }
            sb.append("\n");
            Collections.sort(room.list, (o1, o2) -> o1.name.compareTo(o2.name));
            for (Member member : room.list) {
                sb.append(member.lv).append(" ").append(member.name).append("\n");
            }
        }

        System.out.print(sb);
    }
}

class Room{
    List<Member> list = new ArrayList<>();
    int low;
    int high;
    int m;

    public Room(Member member, int m){
        list.add(member);
        this.low = member.lv - 10;
        this.high = member.lv + 10;
        this.m = m;
    }

    public void addMember(Member member) {
        list.add(member);
    }

    public boolean isOk(Member member) {
        if (member.lv < low || member.lv > high) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        return list.size() >= m;
    }
}

class Member{
    int lv;
    String name;

    public Member(int lv, String name) {
        this.lv = lv;
        this.name = name;
    }
}