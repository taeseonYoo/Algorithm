import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Map<String,Integer> mp = new HashMap<>();
        
        
        int x=5;
        int y=5;
        int dx,dy;
        
        for(int i=0;i<dirs.length();i++){
            char ch = dirs.charAt(i);
            if(ch=='U'){
                dx=0;
                dy=-1;
            }else if(ch=='D'){
                dx=0;
                dy=1;
            }else if(ch=='L'){
                dx=-1;
                dy=0;
            }else{
                dx=1;
                dy=0;
            }
            
            if(x+dx<0 || x+dx>10||y+dy<0||y+dy>10) continue;
        
            
            StringBuilder sb = new StringBuilder();
            
            if(x<x+dx){
                sb.append(x).append(x+dx);
            }else{
                sb.append(x+dx).append(x);
            }
            if(y<y+dy){
                sb.append(y).append(y+dy);
            }else{
                sb.append(y+dy).append(y);
            }
            
            String s = sb.toString();
            
            x = x+dx; 
            y = y+dy;
            
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        answer = mp.size();
        
        return answer;
    }
}