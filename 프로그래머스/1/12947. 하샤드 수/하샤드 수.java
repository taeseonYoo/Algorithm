class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int t = x;
        int sum = 0;
        while(t > 0){
            sum += t % 10;
            t /= 10;
        }
        answer = x%sum==0 ? true : false;
        return answer;
    }
}