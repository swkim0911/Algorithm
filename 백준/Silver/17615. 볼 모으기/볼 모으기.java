import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Cleaner;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        int RCnt = 0;
        int BCnt = 0;
        int[][] edgeCnt = new int[2][2]; // edgeCnt[0][0]: R Left, edgeCnt[0][1]: R Right, edgeCnt[1][0]: B Left, edgeCnt[1][1]: B Right
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if(c == 'R'){
                RCnt += 1;
            }else if(c == 'B'){
                BCnt += 1;
            }
        }
        // 왼쪽에서 연속된 문자열이 몇개 인지
        char leftChar = charArray[0];
        int leftTotal = 1;
        int i = 1;
        while (i < n && charArray[i] == leftChar) {
            leftTotal += 1;
            i += 1;
        }
        if(leftChar == 'R'){
            edgeCnt[0][0] += leftTotal;
        }else{
            edgeCnt[1][0] += leftTotal;
        }

        // 오른쪽에서 연속된 문자열이 몇개 인지
        char rightChar = charArray[n-1];
        int rightTotal = 1;
        i = n-2;
        while (i >= 0 && charArray[i] == rightChar) {
            rightTotal += 1;
            i -= 1;
        }
        if(rightChar == 'R'){
            edgeCnt[0][1] += rightTotal;
        }else{
            edgeCnt[1][1] += rightTotal;
        }

        int RMin = Math.min(RCnt - edgeCnt[0][0], RCnt - edgeCnt[0][1]);
        int BMin = Math.min(BCnt - edgeCnt[1][0], BCnt - edgeCnt[1][1]);
        System.out.println(Math.min(RMin, BMin));

    }
}
