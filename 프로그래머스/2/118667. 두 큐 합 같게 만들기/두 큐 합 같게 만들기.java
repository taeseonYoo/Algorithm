class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int[] totalQueue = new int[queue1.length + queue2.length];
        
        long queue1Sum = 0;
        long queue2Sum = 0;
        
        for(int i=0;i<queue1.length;i++){
            int num = queue1[i];
            totalQueue[i] = num;
            queue1Sum += num;
        }
        
        for(int i=queue1.length;i<queue1.length+queue2.length;i++){
            int num = queue2[i-queue1.length];
            totalQueue[i] = num;
            queue2Sum += num;
        }
        
        //각 큐의 합을 중간 값으로 나눌 수 없다면 -1을 반환한다.
        if((queue1Sum + queue2Sum)%2 !=0) return -1;
        
        int left = 0;
        int right = queue1.length;
        long middle = (queue1Sum + queue2Sum) /2;
        
        while(right < totalQueue.length){
            
            if(queue1Sum == middle){
                return answer;
            }else if(queue1Sum > middle){
                queue1Sum -= totalQueue[left++];
            }else{
                queue1Sum += totalQueue[right++];
            }
            answer++;
        }
        
        return -1;
    }
}