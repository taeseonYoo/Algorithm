import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        List<Integer> list = new ArrayList<>();
        
        //yellow의 약수 구하기
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i==0){
                list.add(i);
            }
        }
        
        for(int i=0;i<list.size();i++){
            
            int height = list.get(i);
            int width = yellow /height;
                
            if(((width+2)*2+ height*2) == brown){
                answer[0]=width+2;
                answer[1]=height+2;
                break;
            }
            
        }
        
        
        
        return answer;
    }
}