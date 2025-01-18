import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<=discount.length-10;i++){
            map.clear();
            
            for(int j=i;j<i+10;j++){
                map.put(discount[j],map.getOrDefault(discount[j],0)+1);
            }
            
            boolean join = true;
            for(int k=0;k<want.length;k++){
                Integer a = map.get(want[k]);
                if(a == null || a < number[k]){
                    join = false;
                    break;
                }
            }
            
            if(join){
                answer++;
            }
        }
        return answer;
    }
}