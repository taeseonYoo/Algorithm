class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        int [] ch = new int[26];
        
        for(int i=0;i<26;i++){
            ch[i]=1;
        }
        
        for(int i=0;i<skip.length();i++){
            int idx = skip.charAt(i)-'a';
            
            ch[idx]--;
        }
        
        for(int i=0;i<s.length();i++){
            
            int cnt=0;
            char c = s.charAt(i);
            
            
            while(cnt<=index){
                
                if(cnt == index){
                    answer+=c;
                    break;
                }
                
                if(c=='z') {
                    c = 'a';
                }
                else{
                    c = (char) (c+1);
                }
                
                if(ch[c-'a']!=0){
                    cnt++;
                }
                
            }
        }
        
        return answer;
    }
}