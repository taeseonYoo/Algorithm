import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        List<Integer> list = new ArrayList<>();
        
        while(n>0){
            list.add((int) (n%10));
            n /= 10;
        }
        
        return list;
    }
}