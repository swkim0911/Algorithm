import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amounts) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> sellerToNumber = new HashMap<>(); // map<seller, number>
        HashMap<String, String> childToParent = new HashMap<>(); // map<seller, parent>
        for(int i = 0; i < enroll.length; i++){
            sellerToNumber.put(enroll[i] , i);
            childToParent.put(enroll[i], referral[i]);
        }
        for(int i = 0; i < sellers.length; i++){
            String seller = sellers[i];
            int amount = amounts[i];
            int money = amount * 100;
            
            while(!seller.equals("-")){
                int rest = money / 10;
                answer[sellerToNumber.get(seller)] += money - rest;
                if(rest == 0) break;
                money = rest;
                seller = childToParent.get(seller);
            }
        }
        return answer;
    }
}

// center(root) = -1;
// 1. 