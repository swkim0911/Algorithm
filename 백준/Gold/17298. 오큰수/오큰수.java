import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(Integer v : arr){
            sb.append(v).append(" ");
        }
        System.out.print(sb);
    }
}

// 브루트 포스: n^2
// 3 5 2 7
// 9 5 4 8

// 배열에 뒤부터 보면서 스택에 오름차순으로 저장되게 하기