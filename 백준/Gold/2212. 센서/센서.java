import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort((o1,o2) -> o1 - o2);
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            resultList.add(list.get(i + 1) - list.get(i));
        }
        resultList.sort((o1, o2) -> o2 - o1);
        long answer = 0L;
        for (int i = k - 1; i < resultList.size(); i++) {
            answer += resultList.get(i);
        }
        System.out.println(answer);
    }
}

/**
 * 1. set으로 정렬하기
 * 2. 앞 뒤 차이값으로 정렬하기
 * 3. k개수 만큼은 앞에서 뛰어넘고 남은 뒤에 차이값들 모두 더한 값이 답.
 * 집중국의 수신 가능 영역의 길의 합의 최솟값이니 센서 사이가 비교적 먼 것은 집중국을 각각 둬서 그 거리를 포함하지 않게 하면 최솟값을 구할 수 있다.
 */
/**
 * 10
 * 5
 * 3 6 7 8 10 12 14 15 18 20
 *
 * 3 1 1 2 2 2 1 3 2
 *
 * 1 3 6 6 7 9
 *
 * 차이가 가장 큰 곳을 나누면 된다.
 */