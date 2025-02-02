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
                intersect+= Math.min(a.get(key),b.get(key));
                union+= Math.max(a.get(key),b.get(key));      
            }else{ //교집합이 아닌 값은 합집합에 추가
                union += a.get(key);
            }
        }
        for(String key: b.keySet()){
            if(!a.containsKey(key)){
                union += b.get(key);
            }
        }
        
        
        answer = union==0 ? 1*65536 : (int)((double)intersect/union * 65536);
        
        return answer;
    }
}