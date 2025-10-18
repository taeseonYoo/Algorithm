class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0]=0;
        answer[1]=sequence.length-1;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < sequence.length){
            
            sum += sequence[end];
            
            while(sum>k &&start <= end){
                sum -= sequence[start++];
            }
            
            if(sum == k){
                if(end-start<answer[1]-answer[0]){
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            
            end++;
        }
        
        
        return answer;
    }
}