import java.util.*;


class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer, int[]> degreeInfoMap = new HashMap<>(); // 
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(!degreeInfoMap.containsKey(a)){
                degreeInfoMap.put(a, new int[2]);
            }
            if(!degreeInfoMap.containsKey(b)){
                degreeInfoMap.put(b, new int[2]);
            }
            degreeInfoMap.get(a)[0] += 1;
            degreeInfoMap.get(b)[1] += 1;
        }
        int created = 0;
        for(Map.Entry<Integer, int[]> entry : degreeInfoMap.entrySet()){
            int vertex = entry.getKey();
            int[] degreeInfo = entry.getValue();
            int out = degreeInfo[0]; // 나가는 degree
            int in = degreeInfo[1]; // 들어오는 degree
            if(out >= 2 && in == 0){
                created = vertex;
            }else if(out == 2 && in >= 2){
                answer[3] += 1;
            }else if(out == 0){
                answer[2] += 1;
            }
        }
        answer[0] = created;
        answer[1] = degreeInfoMap.get(created)[0] - (answer[2] + answer[3]);
        
        return answer;
    }
}