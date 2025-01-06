class Solution {
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {

        permute(dungeons ,0 ,k);
        
        return answer;
    }
    
    public void permute(int[][] dungeons, int p, int k){
        
        if(p == dungeons.length-1){
            
            int total = 0;
            
            for(int[] dungeon : dungeons){
                if(dungeon[0] <= k){
                    total++;
                    k -= dungeon[1];
                }
            }
            answer = answer<total ? total : answer; 
            
        }
        
        for(int i=p;i<dungeons.length;i++){
            swap(dungeons,p,i);
            permute(dungeons, p+1,k);
            swap(dungeons,p,i);
        }
    }
    public void swap(int[][] dungeons,int i,int j){
        int[] temp = dungeons[i];
        dungeons[i] = dungeons[j];
        dungeons[j] = temp;
    }
}