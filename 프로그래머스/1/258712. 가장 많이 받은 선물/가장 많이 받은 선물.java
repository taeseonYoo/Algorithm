class Solution {
    
    int [][] list;
    int [] point;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        
        list = new int[n][n];
        point = new int[n];
        
        for(int i=0;i<gifts.length;i++){
            String[] names = gifts[i].split(" ");
            
            int a=0,b=0;
            
            for(int j=0;j<n;j++){
                if(names[0].equals(friends[j])){
                    a = j;
                }
                if(names[1].equals(friends[j])){
                    b = j;
                }
            }
            
            list[a][b] += 1;
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                point[i] += list[i][j];
                point[j] -= list[i][j];
            }
        }
        
        
        //결과 계산
        for(int i=0;i<n;i++){
            
            int gift = 0;
            
            for(int j=0;j<n;j++){
                
                if(i==j) continue;
                
                int a = list[i][j];
                int b = list[j][i];
                
                if(a > b) gift++;
                else if(a == b && point[i]>point[j]) gift++;
            }
            
            answer = Math.max(gift,answer);
        }
        
        
        
        
        return answer;
    }
}