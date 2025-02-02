import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String,Integer> a = new HashMap<>();
        Map<String,Integer> b = new HashMap<>();
        
        
        for(int i=0;i<str1.length()-1;i++){
            String tmp = str1.substring(i,i+2).toLowerCase();
            if(!Character.isLetter(tmp.charAt(0)) || !Character.isLetter(tmp.charAt(1))){
                continue;
            }
            a.put(tmp,a.getOrDefault(tmp,0)+1);
        }
        for(int i=0;i<str2.length()-1;i++){
            String tmp = str2.substring(i,i+2).toLowerCase();
            if(!Character.isLetter(tmp.charAt(0)) || !Character.isLetter(tmp.charAt(1))){
                continue;
            }
            b.put(tmp,b.getOrDefault(tmp,0)+1);
        }
        
        int union = 0;
        int intersect = 0;
        
        for(String key: a.keySet()){
            if(b.containsKey(key)){
                int min = a.get(key) > b.get(key) ? b.get(key) : a.get(key);
                int max = a.get(key) > b.get(key) ? a.get(key) : b.get(key);
                intersect += min;
                union += max;        
            }else{
                union += a.get(key);
            }
        }
        for(String key: b.keySet()){
            if(!a.containsKey(key)){
                union += b.get(key);
            }
        }
        
        if(union==0) return 1*65536;
        
        
        answer = (int)((double)intersect/union * 65536);
        
        return answer;
    }
}