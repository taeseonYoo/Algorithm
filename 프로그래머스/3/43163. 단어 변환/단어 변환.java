class Solution {
    
    int answer = 51;
    
    public int solution(String begin, String target, String[] words) {
        
        dfs(begin,target,words,0);
        
        return answer = answer == 51 ? 0 : answer;
    }
    public void dfs(String begin,String target,String[] words,int depth){
        
        if(begin.equals(target)){
            answer = Math.min(answer,depth);
        }
        
        for(int i=0;i<words.length;i++){
            int count = 0;
            for(int j=0;j<begin.length();j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    count++;
                }
            }
            if(count == begin.length()-1){
                String[] wo = new String[words.length-1];
                int inx = 0;
                for(int k=0;k<words.length;k++){
                    if(k==i){
                        continue;
                    }
                    wo[inx++] = words[k];
                }
            
                dfs(words[i],target,wo,depth+1);
            }
        }
    }
}