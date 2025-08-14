class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0]=gcd(n,m);
        answer[1]=lcm(n,m);
        
        return answer;
    }
    //최대공약수
    public int gcd(int n,int m){
        int max = Math.max(n,m);
        
        int i;
        for(i=max;i>=1;i--){
            if(n%i==0 && m%i==0) break;
        }
        return i;
    }
    //최소공배수
    public int lcm(int n,int m){
        int max = Math.max(n,m);
        
        int i;
        for(i=max;i<=1000000;i++){
            if(i%n==0 && i%m==0) break;
        }
        return i;
    }
}