import java.util.HashSet;
import java.util.Set;

class Solution {

    public Set<Integer> set = new HashSet<>();
    public boolean[] isUsed;
    public int solution(String numbers) {
        for (int l = 1; l <= numbers.length(); l++) {
            isUsed = new boolean[numbers.length()];
            func(numbers, l, "");
        }

        return set.size();
    }

    public void func(String numbers, int len, String strNumber) {
        if (len == strNumber.length()) {
            int number = Integer.parseInt(strNumber);
            if(isPrime(number)) set.add(number);
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if(isUsed[i]) continue;
            isUsed[i] = true;
            func(numbers, len, strNumber + numbers.charAt(i));
            isUsed[i] = false;
        }

    }

    public boolean isPrime(int number) {
        if(number == 0 || number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}