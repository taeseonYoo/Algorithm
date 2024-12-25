import java.util.*;

class Solution {
    public Integer[] arr = new Integer[10000001];
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.fill(arr,0);
        
        for(int tang : tangerine){
            arr[tang]++;
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        
        int j=0;
        while(answer<k){
            answer += arr[j++];
        }
        
        
        
        return j;
    }
}