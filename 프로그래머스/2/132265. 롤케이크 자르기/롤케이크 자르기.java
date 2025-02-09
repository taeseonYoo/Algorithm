import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> s1 = new HashMap<>();
        Map<Integer,Integer> s2 = new HashMap<>();
        
        for(int to : topping){
            s2.put(to,s2.getOrDefault(to,0)+1);
        }
        
        for(int i=0;i<topping.length;i++){
            if(s1.size()==s2.size()) answer++;
            
            int tmp = topping[i];
            
            int n = s2.get(tmp);
            if(n>1){
                s2.put(tmp,n-1);
            }else{
                s2.remove(tmp);
            }
            s1.put(tmp,s1.getOrDefault(tmp,0)+1);
            
        }
        
        return answer;
    }
}