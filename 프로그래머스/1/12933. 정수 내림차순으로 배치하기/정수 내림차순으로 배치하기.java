import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        List<Long> list = new ArrayList<>();
        
        while(n>0){
            list.add( n % 10); 
            n /= 10;
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        for(long a : list){
            answer = (long)answer * 10 + a;
        }
        
        
        return answer;
    }
}