class Solution {
    public boolean solution(int x) {
        
        String[] arr = String.valueOf(x).split("");
        int sum = 0;
        for(String number : arr){
            sum += Integer.parseInt(number);
        }
        return x % sum == 0 ? true : false;
    }
}