import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Prc> q = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.offer(new Prc(i , priorities[i]));
        }
        
        
        int i=0;
        
        while(!q.isEmpty()){
            Prc p = q.poll();
            
            boolean flag = false;
            for(Prc a : q){
                if(p.getPrio() < a.getPrio() ){
                    flag =true;
                    break;
                }
            }
            if(flag){
                q.offer(p);
            }else{
                i++;
                if(p.getIndex()==location){
                    return i;
                }
            }
        }
        
        return answer;
    }
}
class Prc{
    int index;
    int prio;
    public Prc(int index,int prio){
        this.index = index;
        this.prio = prio;
    }
    public int getPrio(){
        return prio;
    }
    public int getIndex(){
        return index;
    }
}

