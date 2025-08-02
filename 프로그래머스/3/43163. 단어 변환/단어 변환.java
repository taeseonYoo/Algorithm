class Solution {
    
    //정답
    int answer = 51;
    
    public int solution(String begin, String target, String[] words) {
        //방문을 확인하기 위한 배열
        boolean[] visited = new boolean[words.length];
        
        dfs(begin,target,words,0,visited);
        
        // 변환할 수 없는 경우에는 0을 리턴한다.
        return answer = answer == 51 ? 0 : answer;
    }
    
    public void dfs(String begin,String target,String[] words,int depth,boolean[] visited){
        
        if(begin.equals(target)){
            answer = Math.min(answer,depth);
            return;
        }
        
        for(int i=0;i<words.length;i++){
            
            int diff = 0;
            // begin과 타겟 word가 한글자만 다른 경우를 확인한다.
            for(int j=0;j<begin.length();j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    diff++;
                }
            }
            //한글자만 다르고, 타겟 word를 사용한 적이 없는 경우를 확인한다.
            if(diff ==1 && !visited[i]){
                visited[i]=true;
                dfs(words[i],target,words,depth+1,visited);
                visited[i]=false;
            }
        }
    }
}