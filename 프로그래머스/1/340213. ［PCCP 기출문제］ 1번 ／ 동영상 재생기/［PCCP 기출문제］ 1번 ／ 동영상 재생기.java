class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int start = getTotalSec(op_start);
        int end = getTotalSec(op_end);
        
        for (String cmd : commands){
            // 1. 오프닝 사이에 있는지 확인
            int cur = getTotalSec(pos);
            if(start <= cur && cur <= end){
                cur = end;
            }
            
            if(cmd.equals("next")){
                int videoLen = getTotalSec(video_len);
                cur = cur + 10 > videoLen ? videoLen : cur + 10;
            }else{
                cur = cur < 10 ? 0 : cur - 10;
            }
            
            if(start <= cur && cur <= end){
                cur = end;
            }
            pos = getTime(cur);    
        }
        return pos;
    }
    
    public static String getTime(int totalSec){
        int min = totalSec / 60;
        int sec = totalSec % 60;
        String time = "";
        time += min < 10 ? "0" + String.valueOf(min) : min;
        time += ":";
        time += sec < 10 ? "0" + String.valueOf(sec) : sec;
        
        return time;
        
    }
    
    public static int getTotalSec(String time){
        int min = Integer.parseInt(time.split(":")[0]);
        int sec = Integer.parseInt(time.split(":")[1]);
        int totalSec = min*60 + sec;
        
        return totalSec;
    }
}

// 현재 위치가 오프닝 사이에 있는 경우 -> op_end
