class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        //최대 공약수
        answer[0]=gcd(n,m);
        
        //최소 공배수
        answer[1]=(n*m)/gcd(n,m);
        
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
}