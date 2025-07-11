import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        HashMap<Character, Integer> firstMap = getCountMap(first);
        String sortedFirst = getSortedString(first);
        int answer = 0;

        label : for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            HashMap<Character, Integer> strMap = getCountMap(str);
            String sortedStr = getSortedString(str);

            if (sortedStr.equals(sortedFirst)) { // 1. 같은 구성인지
                answer++;
            }else{
                if (sortedStr.length() == sortedFirst.length()) { // 길이가 같은데 하나만 바꾸면 같아지면 유사한 것 (n-1개만 같으면 됨)
                    Set<Character> allKeys = new HashSet<>(firstMap.keySet());
                    allKeys.addAll(strMap.keySet());

                    int cnt = 0;
                    for (Character key : allKeys) {
                        int v1 = firstMap.getOrDefault(key, 0);
                        int v2 = strMap.getOrDefault(key, 0);
                        cnt += Math.abs(v1 - v2);
                    }

                    if (cnt == 2) { // 하나만 바꾼 경우
                        answer++;
                    }
                }else if(Math.abs(sortedStr.length() - sortedFirst.length()) == 1){ // 길이가 1차이 나는데 1개 없애거나 추가해서 같으면 유사한 것 (작은 것의 알파벳 모두 큰 것에 포함되어 있으면 됨)
                    if (sortedStr.length() < sortedFirst.length()) {
                        for (Map.Entry<Character, Integer> entry : strMap.entrySet()) {
                            Character key = entry.getKey();
                            Integer value = entry.getValue();
                            Integer firstValue = firstMap.getOrDefault(key, 0);
                            if(firstValue < value) continue label;
                        }
                    }else{
                        for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
                            Character key = entry.getKey();
                            Integer value = entry.getValue();
                            Integer strValue = strMap.getOrDefault(key, 0);
                            if(strValue < value) continue label;
                        }
                    }
                    answer++;

                }// god good
            }
        }
        System.out.println(answer);
    }

    private static HashMap<Character, Integer> getCountMap(String str) {
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }
        return strMap;
    }

    public static String getSortedString(String string) {
        char[] firstCharArray = string.toCharArray();
        Arrays.sort(firstCharArray);
        return new String(firstCharArray);
    }

}
