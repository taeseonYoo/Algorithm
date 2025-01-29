class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                int result = 0;
                
                int p = arr1[i].length-1;
                int q = arr2.length-1;
                while(p>=0 || q>=0){
                    result += arr1[i][p]*arr2[q][j];
                    p--;
                    q--;
                }
                
                answer[i][j]= result;
            }
        }
        return answer;
    }
    
}