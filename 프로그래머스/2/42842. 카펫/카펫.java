
class Solution {
    public int[] solution(int brown, int yellow) {
        //가로 >= 세로
        int total = brown + yellow;

        for(int h=3; h<=total-3; h++){
            int w = total/h;

            if(total % w == 0 && w >= h){
                if((w-2) * (h-2) == yellow){
                    return new int[]{w,h};
                }
            }
        }
        return new int[0];
    }
}