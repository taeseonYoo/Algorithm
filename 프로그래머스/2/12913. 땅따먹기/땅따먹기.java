class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int [] arr = new int[4];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = land[0][i];
        }
        
        for(int i=1;i<land.length;i++){
            
            int [] tmp = new int[4];
            
            for(int j=0;j<land[i].length;j++){
                int target = land[i][j];
                
                
                int max = 0;
                for(int k=0;k<4;k++){
                    if(j!=k){
                        max = Math.max(target + arr[k],max);
                    }
                }
                tmp[j] = max;
            }
            for(int q=0;q<4;q++){
                arr[q] = tmp[q];
            }
            
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer,arr[i]);
        }

        return answer;
    }
}