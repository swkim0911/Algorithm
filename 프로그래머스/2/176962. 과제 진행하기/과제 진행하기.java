import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        //init
        List<String> answer = new ArrayList<>(); // 정답
        PriorityQueue<Plan> pq = new PriorityQueue<>();
        Stack<Plan> stack = new Stack<>(); // 중지된 plan stack
        for(String[] plan : plans){
            pq.add(new Plan(plan[0], plan[1], plan[2]));
        }
        Plan cur = pq.poll();
        int curTime = cur.start;
        boolean flag = true;
        while(flag){
            
            int minTime = 0; // 진행되고 있는 시간
            boolean isProcessing = true;
            
            while(true){
                
                // 처리가 완료되는 경우
                if(minTime == cur.playTime){
                    answer.add(cur.name);
                    isProcessing = false;
                    
                    // 신규 과제가 있는 경우
                    if(!pq.isEmpty() && curTime == pq.peek().start){
                        cur = pq.poll();
                        curTime += minTime;
                        break;
                    }
                    
                    if(!stack.isEmpty()){
                        cur = stack.pop();
                        curTime += minTime;
                        break;
                    }
                    
                    if(pq.isEmpty() && stack.isEmpty()){
                        flag = false;
                        break;
                    }
                }
                
                // 기존에 과제가 진행 중인데 새로운 과제를 시작할 시각이 되었을 때
                if(!pq.isEmpty() && (curTime + minTime) == pq.peek().start){
                    if(isProcessing){
                        cur.playTime -= minTime;
                        stack.add(cur);
                    }
                    cur = pq.poll();
                    curTime = cur.start;
                    break;
                }
                
                minTime++;
            }
        }
            
        return answer.toArray(new String[0]);
    }
}
class Plan implements Comparable<Plan>{
    String name;
    int start;
    int playTime;
    
    public Plan(String name, String startTime, String playTime){
        this.name = name;
        this.start = Integer.parseInt(startTime.split(":")[0])*60 + Integer.parseInt(startTime.split(":")[1]);
        this.playTime = Integer.parseInt(playTime);
    }
    
    
    @Override
    public int compareTo(Plan o){
        return this.start - o.start;
    }
}
