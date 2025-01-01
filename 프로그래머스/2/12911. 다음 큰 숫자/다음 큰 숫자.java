class Solution {
    public int solution(int n) {
        
        
        String line = Integer.toBinaryString(n);
        int answer = n+1;
        
        int target = line.replace("0","").length();
        
        while(true){
            int next = Integer.toBinaryString(answer).replace("0","").length();
            
            if(next == target){
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}