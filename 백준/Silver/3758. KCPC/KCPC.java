import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Team> teams = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if(i == 0){
                    Team dump = new Team(i, k);
                    dump.sum = -1;
                    teams.add(dump);
                }else{
                    teams.add(new Team(i, k));
                }
            }

            for (int z = 0; z < m; z++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                Team curTeam = teams.get(i);
                curTeam.scores[j] = Math.max(curTeam.scores[j], s); // j번 최고 점수 갱신
                curTeam.cnt += 1; // 제출 횟수
                curTeam.time = z; //
            }
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j < k + 1; j++) {
                    sum += teams.get(i).scores[j];
                }
                teams.get(i).sum = sum;
            }
            Collections.sort(teams, (o1,o2) -> {
                if (o1.sum == o2.sum) {
                    if (o1.cnt == o2.cnt) {
                        return o1.time - o2.time;
                    }
                    return o1.cnt - o2.cnt;
                }
                return o2.sum - o1.sum;
            });
            for (int i = 0; i <= n; i++) {
                Team team = teams.get(i);
                if (team.number == t) {
                    sb.append(i + 1).append("\n");
                }
            }
        }
        System.out.print(sb);

    }
    // 각 팀에 필요한 데이터. 각 문제에 대한 최종 점수 -> 총 점수 합., 제출 횟수. 마지막 제출 시간
    // 점수 높은 순으로 정렬 -> 같으면. 제출 횟수

    static class Team{
        int number;
        int[] scores;
        int sum;
        int cnt; // 제출 횟수
        int time; // 마지막 제출 시간

        public Team(int number, int k) {
            this.number = number;
            this.scores = new int[k + 1];
            this.sum = 0;
            this.cnt = 0;
            this.time = 0;
        }
    }
}
