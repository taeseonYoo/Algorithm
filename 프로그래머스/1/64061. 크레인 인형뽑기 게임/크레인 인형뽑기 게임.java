import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                int target = board[i][move-1];
                if(target != 0){
                    
                    if(st.isEmpty()){
                        st.push(target);
                    }else if(st.peek()==target){
                        answer+=2;
                        st.pop();
                    }else{
                        st.push(target);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
            
            
        }
        
        
        
        return answer;
    }
}