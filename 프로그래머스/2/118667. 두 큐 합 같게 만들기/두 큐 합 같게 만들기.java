// 두 큐의 원소들의 값을 더한다.
// 중간 값을 찾는다.

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum = 0;
        
        for(int i=0;i<queue1.length;i++){
            sum += queue1[i];
        }
        for(int j=0;j<queue2.length;j++){
            sum += queue2[j];
        }
        
        if(sum %2 !=0 )return -1;
        
        long middle = sum/2;
        
        int startIdx = 0;
        int endIdx = queue1.length;
        long partSum = 0;
        for(int i=0;i<queue1.length;i++){
            partSum += queue1[i];
        }
    
        
        boolean flag = false;
        
        while(startIdx < queue1.length + queue2.length){
            
            if(partSum<middle){
                if(endIdx < queue1.length){
                    partSum += queue1[endIdx];
                }else{
                    partSum += queue2[endIdx-queue1.length];
                }
                endIdx++;
                if(endIdx >= queue1.length + queue2.length) endIdx = 0;
            }else if(partSum > middle){
                if(startIdx < queue1.length){
                    partSum -= queue1[startIdx];
                }else{
                    partSum -= queue2[startIdx-queue1.length];
                }
                startIdx++;
            }else{
                flag = true;
                break;
            }
            answer++;
        }
        
        if(!flag) answer = -1;
        
        return answer;
    }
}