class Solution {
    int[] nums;
    public int solution(int n) {
        int answer = 0;
        
        nums = new int[n+1];
        
        for(int i=2;i<=n;i++){
            for(int j=2;i*j<=n;j++){
                nums[i*j]=1;
            }
        }
        
        for(int i=2;i<=n;i++){
            if(nums[i]==0) answer++;
        }
        
        return answer;
    }
}