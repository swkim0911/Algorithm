import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("end")) break;
            int x = 0;
            int o = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == 'X'){
                    x += 1;
                }else if(c == 'O'){
                    o += 1;
                }
            }
            if(!(x == o || x == (o + 1))){ // 개수 확인
                sb.append("invalid").append("\n");
                continue;
            }
            // 꽉 차지도 않고, 3 line이 없다면
            if(x + o != 9 && !isMadeThreeLine(input)){
                sb.append("invalid").append("\n");
                continue;
            }
            // O가 이기는 조건은 항상 x==o인데 그렇지 않을 때
            if( x!=o && isOWin(input)){
                sb.append("invalid").append("\n");
                continue;
            }
            // x가 이길 때는 x가 항상 1 많다. 그렇지 않을 때
            if (!(x > o) && isXWin(input)) {
                sb.append("invalid").append("\n");
                continue;
            }
            sb.append("valid").append("\n");
        }

        System.out.print(sb);
    }

    public static boolean isXWin(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] == 'X' && (charArray[0] == charArray[1] && charArray[1] == charArray[2])) {
            return true;
        }
        if (charArray[3] == 'X' && (charArray[3] == charArray[4] && charArray[4] == charArray[5])) {
            return true;
        }
        if (charArray[6] == 'X' && (charArray[6] == charArray[7] && charArray[7] == charArray[8])) {
            return true;
        }
        if (charArray[0] == 'X' && (charArray[0] == charArray[3] && charArray[3] == charArray[6])) {
            return true;
        }
        if (charArray[1] == 'X' && (charArray[1] == charArray[4] && charArray[4] == charArray[7])) {
            return true;
        }
        if (charArray[2] == 'X' && (charArray[2] == charArray[5] && charArray[5] == charArray[8])) {
            return true;
        }
        if (charArray[0] == 'X' && (charArray[0] == charArray[4] && charArray[4] == charArray[8])) {
            return true;
        }
        if (charArray[2] == 'X' && (charArray[2] == charArray[4] && charArray[4] == charArray[6])) {
            return true;
        }
        return false;
    }

    public static boolean isOWin(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] == 'O' && (charArray[0] == charArray[1] && charArray[1] == charArray[2])) {
            return true;
        }
        if (charArray[3] == 'O' && (charArray[3] == charArray[4] && charArray[4] == charArray[5])) {
            return true;
        }
        if (charArray[6] == 'O' && (charArray[6] == charArray[7] && charArray[7] == charArray[8])) {
            return true;
        }
        if (charArray[0] == 'O' && (charArray[0] == charArray[3] && charArray[3] == charArray[6])) {
            return true;
        }
        if (charArray[1] == 'O' && (charArray[1] == charArray[4] && charArray[4] == charArray[7])) {
            return true;
        }
        if (charArray[2] == 'O' && (charArray[2] == charArray[5] && charArray[5] == charArray[8])) {
            return true;
        }
        if (charArray[0] == 'O' && (charArray[0] == charArray[4] && charArray[4] == charArray[8])) {
            return true;
        }
        if (charArray[2] == 'O' && (charArray[2] == charArray[4] && charArray[4] == charArray[6])) {
            return true;
        }
        return false;
    }

    public static boolean isMadeThreeLine(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] != '.' && (charArray[0] == charArray[1] && charArray[1] == charArray[2])) {
            return true;
        }
        if (charArray[3] != '.' && (charArray[3] == charArray[4] && charArray[4] == charArray[5])) {
            return true;
        }
        if (charArray[6] != '.' && (charArray[6] == charArray[7] && charArray[7] == charArray[8])) {
            return true;
        }
        if (charArray[0] != '.' && (charArray[0] == charArray[3] && charArray[3] == charArray[6])) {
            return true;
        }
        if (charArray[1] != '.' && (charArray[1] == charArray[4] && charArray[4] == charArray[7])) {
            return true;
        }
        if (charArray[2] != '.' && (charArray[2] == charArray[5] && charArray[5] == charArray[8])) {
            return true;
        }
        if (charArray[0] != '.' && (charArray[0] == charArray[4] && charArray[4] == charArray[8])) {
            return true;
        }
        if (charArray[2] != '.' && (charArray[2] == charArray[4] && charArray[4] == charArray[6])) {
            return true;
        }

        return false;
    }
}




