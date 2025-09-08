import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int move : moves){
            
            int target = 0;
            //목표물을 집는다.
            for(int i=0;i<board.length;i++){
                target = board[i][move-1];
                if(target != 0){
                    board[i][move-1] = 0;
                    break;
                }
            }
            
            //집을 인형이 없다면
            if(target == 0){
                continue;
            } 
            
            //바구니의 가장 위의 인형과 비교한다.
            if(!st.isEmpty() && st.peek()==target){
                answer+=2;
                st.pop();
            }else{
                st.push(target);
            }
        }
        
        
        
        return answer;
    }
}