class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double a = Math.sqrt(n);
        
        if(a == (int)a){
            return (long)((a+1)*(a+1));
        }
        return -1;
    }
}