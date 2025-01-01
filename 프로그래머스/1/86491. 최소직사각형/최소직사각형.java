class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int wmax = 0;
        int hmax = 0;
        
        for(int i=0;i<sizes.length;i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            if(width < height){
                sizes[i][0] = height;
                sizes[i][1] = width;
            }
            
            wmax = Math.max(wmax,sizes[i][0]);
            hmax = Math.max(hmax,sizes[i][1]);
        }
        answer = wmax * hmax;
        return answer;
    }
}