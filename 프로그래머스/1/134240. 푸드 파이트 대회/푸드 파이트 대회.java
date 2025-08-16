class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        // 물을 먹는 경우는 중간에 배치한다.
        answer.append("0");
        
        for(int i=food.length-1;i>0;i--){
            //준비된 음식을 절반씩 나누어 먹는다.
            int target = food[i]/2;
            //준비된 음식을 배치한다.
            while(target-->0){
                answer.append(i);
                answer.insert(0,i);
            }
            
        }
        return answer.toString();
    }
}