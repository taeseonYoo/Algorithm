class Solution {
    
    int[][] keyPad = {
        {3,1}, //0
        {0,0}, //1
        {0,1}, //2
        {0,2}, //3
        {1,0}, //4
        {1,1}, //5
        {1,2}, //6
        {2,0}, //7
        {2,1}, //8
        {2,2}  //9
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] left = {3,0};
        int[] right = {3,2};
        
        
        for(int target : numbers){
            
            //왼쪽 키패드
            if(target == 1 || target == 4 || target == 7){
                left=keyPad[target];
                answer.append("L");
            }else if(target == 3 || target == 6 || target == 9){
                right = keyPad[target];
                answer.append("R");
            }else{
                if(distinct(left,target)<distinct(right,target)){
                    left = keyPad[target];
                    answer.append("L");
                }else if(distinct(left,target)>distinct(right,target)){
                    right = keyPad[target];
                    answer.append("R");
                }else{
                    if("left".equals(hand)){
                        left = keyPad[target];
                        answer.append("L");
                    }else{
                        right = keyPad[target];
                        answer.append("R");
                    }
                }
            }
        }
        return answer.toString();
    }
    //거리를 측정하는 메서드
    public int distinct(int[] pos,int target){
        return Math.abs(pos[0]-keyPad[target][0]) + Math.abs(pos[1]-keyPad[target][1]);
    }
}