import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            nameToIdx.put(friends[i], i);
        }
        int[][] record = new int[friends.length][friends.length];
        int[][] total = new int[2][friends.length];// total[0][j]: j번 째가 총 준 개수, total[1][j]: j번 째가 총 받은 개수
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int from = nameToIdx.get(split[0]);
            int to = nameToIdx.get(split[1]);
            record[from][to] += 1;
            total[0][from] += 1;
            total[1][to] += 1;
        }
        int[] answerList = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = i; j < friends.length; j++) {
                if(i == j) continue;
                if ((record[i][j] != 0 || record[j][i] != 0) && record[i][j] != record[j][i]) {
                    if(record[i][j] > record[j][i]){
                        answerList[i]++;
                    }else{
                        answerList[j]++;
                    }
                }else{
                    int valI = total[0][i] - total[1][i];
                    int valJ = total[0][j] - total[1][j];
                    if (valI > valJ) {
                        answerList[i]++;
                    } else if (valI < valJ) {
                        answerList[j]++;
                    }
                }
            }
        }
        Arrays.sort(answerList);

        return answerList[friends.length - 1];
    }
}
