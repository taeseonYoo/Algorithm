import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> s = new HashSet<>();
        
        
        for(int k=1;k<=elements.length;k++){
            for(int i=0;i<elements.length;i++){
            
                int sum = 0;
                for(int j=i;j<i+k;j++){
                    sum += elements[j%elements.length];
                }
                s.add(sum);
            }
        }
        
        return s.size();
    }
}