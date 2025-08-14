class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        // 1. 3진법으로 변환 + sb에 역순으로 저장
        long num = n;
        
        while(num>0){
            sb.append(num%3);
            num /= 3;
        }
        
        num = Long.parseLong(sb.toString());
        
        
        // 2. 10진법으로 변환
        String target = String.valueOf(num);
        
        for(int i=0;i<target.length();i++){
            char bit = target.charAt(i);
            
            answer += Math.pow(3,target.length()-i-1)* (bit - '0');
        }
        
        return answer;
    }
}