import java.util.*; 

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        secretNumber(n,1,q,ans);
        
        return answer;
    }
    
    Set<Integer> visited = new HashSet<>();
    
    public void secretNumber(int n,int start,int[][] q,int[] ans){
        if(visited.size() == 5){
            if(isPossible(q,ans)){
                answer++;
            }
            return;
        }
        
        //1~n사이의 숫자 순열 선택
        for(int i=start;i<=n;i++){
            if(!visited.contains(i)){
                visited.add(i);
                secretNumber(n,i+1,q,ans);
                visited.remove(i);
            }
        }
        
    }

    public boolean isPossible(int[][] q, int[] ans){
        
        for(int i=0;i<q.length;i++){
            int count = 0;
            
            for(int j=0;j<q[i].length;j++){
                if(visited.contains(q[i][j])) count++;
            }
            
            if(count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}