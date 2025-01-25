import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Map<Integer,Integer> mp = new HashMap<>();
        
        
        for(int k=1;k<=elements.length;k++){
            for(int i=0;i<elements.length;i++){
            
                int result = 0;
                for(int j=i;j<i+k;j++){
                    result += elements[j%elements.length];
                }
                mp.put(result,1);
            }
        }
        
        return mp.size();
    }
}