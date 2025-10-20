import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        List<ArrayList<Integer>> warehouse = new ArrayList<>();
        
        for(int i=0;i<=w;i++){
            warehouse.add(new ArrayList<>());
        }
    
        
        int box=1;
        int pt = 1;
        
        while(box<=n){
            if(box % w == 0){
                warehouse.get(pt).add(box++);
                continue;
            }
            
            if( (box / w)%2==0 ){
                warehouse.get(pt++).add(box++);
            }else{
                warehouse.get(pt--).add(box++);
            }
        }
        
        for(int i=1;i<=w;i++){
            answer = 0;
            for(int j=0;j<warehouse.get(i).size();j++){
                int target = warehouse.get(i).get(j);
                if(target == num){
                    answer = warehouse.get(i).size()-j;
                }
            }
            if(answer!=0) break;
        }
        
        
        return answer;
    }
}