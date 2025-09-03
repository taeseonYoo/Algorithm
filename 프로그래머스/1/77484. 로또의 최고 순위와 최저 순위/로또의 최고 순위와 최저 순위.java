/**
로또 배열은 6개, win_nums도 6개
O(6!)의 시간 -> 상수 시간
*/

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        //correct는 일치하는 번호의 개수, zero는 0의 개수
        int correct = 0;
        int zero = 0;
        for(int i=0;i<lottos.length;i++){
            int target = lottos[i];
            if(target == 0) {
                zero++;
                continue;
            }
            //일치하는 번호 탐색
            for(int j=0;j<win_nums.length;j++){
                if(target == win_nums[j]){
                    correct++;
                    break;
                }
            }
        }
        answer[0] = rank(correct+zero);
        answer[1] = rank(correct);
        
        return answer;
    }
    
    int rank(int correct){
        if(correct == 0) return 6;
        
        return 6-correct+1;
    }
    
}