import java.util.*;

class Solution {
    public List<Long> solution(long n) {
        List<Long> list = new ArrayList<>();
        
        while(n/10 >0){
            list.add(n%10);
            n /= 10;
        }
        list.add(n);
        
        return list;
    }
}