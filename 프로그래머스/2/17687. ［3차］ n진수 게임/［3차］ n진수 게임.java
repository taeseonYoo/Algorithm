class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        while(sb.length() < t * m){
            String result = Integer.toString(num++,n).toUpperCase();
            sb.append(result);
        }
        
        int index = p-1;
        while(t-- >0){
            answer.append(sb.charAt(index));
            index += m;
        }
        
        
        return answer.toString();
    }
}