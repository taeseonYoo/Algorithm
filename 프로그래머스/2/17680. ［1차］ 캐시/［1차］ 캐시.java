import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        if(cacheSize==0) return cities.length*5;
        
        List<String> l = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++){
            
            String city = cities[i].toLowerCase();
            
            if(l.contains(city)){
                l.remove(city);
                l.add(city);
                answer++;    
            }else{
                if(l.size()>=cacheSize){
                    l.remove(0);
                }
                l.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}
