import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        
        List<Long> list = new ArrayList<>();
        
        long startRow = left / n ; 
        long startColumn = left % n ; 
        
        long endRow = right / n ; 
        
        for(long i=startColumn;i<n;i++){
            if(list.size()==(right-left+1)){
                break;
            }
            if(startRow<i){
                list.add(i+1);
            }else{
                list.add(startRow+1);
            }
        }
        startRow++;
        
        while(startRow <= endRow){
            
            for(long i=0;i<n;i++){
                
                if(list.size()==(right-left+1)){
                    break;
                }
                
                if(startRow<i){
                    list.add(i+1);
                }else{
                    list.add(startRow+1);
                }
            }
            startRow++;
        }
        
        return list;
    }
}