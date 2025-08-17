
class Solution {
    public int solution(String s) {
        String answer = "";
        
        String tmp = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            //해당 위치의 문자가 숫자인 경우
            if(Character.isDigit(ch)){
                answer+= ch;
            }else{
                tmp += ch;
                
                int num = changeNum(tmp);
                if(num!=-1){
                    System.out.println("gd");
                    answer += num+"";
                    tmp="";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    int changeNum(String num){
        
        if("zero".equals(num)) return 0;
        else if("one".equals(num)) return 1;
        else if("two".equals(num)) return 2;
        else if("three".equals(num)) return 3;
        else if("four".equals(num)) return 4;
        else if("five".equals(num)) return 5;
        else if("six".equals(num)) return 6;
        else if("seven".equals(num)) return 7;
        else if("eight".equals(num)) return 8;
        else if("nine".equals(num)) return 9;
        
        return -1;
    }
}