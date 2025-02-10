import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        Set<String> s = new HashSet<>();
        
        int x=5,y=5;
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
            int nx= x+dx;
            int ny = y+dy;
            
            if(nx<0 || nx>10||ny<0||ny>10) continue;
            
            StringBuilder sb = new StringBuilder();
            
            s.add(""+x+y+nx+ny);
            s.add(""+nx+ny+x+y);
        
    
            //이동
            x = nx; 
            y = ny;
        }
        
        
        return s.size()/2;
    }
}