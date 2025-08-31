class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int[] demical = new int[3000];
        
        //소수를 미리 확인한다.
        for(int i=2;i<3000;i++){
            for(int j=2;i*j<3000;j++){
                demical[i*j]=1;
            }
        }

        //3중 포문으로 세개의 합을 결정한다.
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(demical[sum]==0) answer++;
                }
            }
        }

        return answer;
    }
}