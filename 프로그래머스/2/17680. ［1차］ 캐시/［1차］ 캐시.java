import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        LinkedList<String> l = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++){
            
            String city = cities[i].toLowerCase();
            
            if(l.contains(city) && cacheSize>0){
                l.remove(city);
                l.offer(city);
                answer++;    
            }else{
                if(l.size()>=cacheSize){
                    l.poll();
                }
                l.offer(city);
                answer+=5;
            }
        }
        return answer;
    }
}
