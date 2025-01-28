import java.util.*;

class Solution {
    public List<Integer> solution(int n, long left, long right) {
        
        List<Integer> list = new ArrayList<>();
        
        for(long i=left;i<=right;i++){
            
            if(i/n <= i%n){
                list.add((int)(i%n+1));
            }else{
                list.add((int)(i/n +1));
            }
        }
        
        return list;
    }
}