class Solution {
    long[] answer ;
    public long solution(int n) {
        
        answer = new long[n+1];
        
        answer[1]=1;
        
        
        for(int i=2;i<=n;i++){
            answer[i] = (answer[i-1]+ answer[i-2])%1234567;
        }
        
        return answer[n]%1234567;
    }
    
}