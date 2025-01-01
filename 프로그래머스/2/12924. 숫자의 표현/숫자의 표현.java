class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int result = 0; 
            int target = i;
            while(result < n){
                
                result += target;
                target++;
                
                if(result == n){
                    answer++;
                }
            }
            
        }        
        return answer;
    }
}