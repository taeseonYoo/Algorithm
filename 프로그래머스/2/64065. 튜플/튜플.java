import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        
        s = s.replace("},{"," ");
        s = s.substring(2,s.length()-2);
        String[] sa = s.split(" ");
        
        
        
        Arrays.sort(sa, new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                if(o1.length()<o2.length()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        
        // for(int i=0;i<sa.length;i++){
        //     System.out.println(sa[i]);
        // }
        
        
        answer.add(Integer.parseInt(sa[0]));
        
        for(int i=1;i<sa.length;i++){
            String[] tmp = sa[i].split(",");
            
            for(int j=0;j<answer.size();j++){
                
                for(int k=0;k<tmp.length;k++){
                    if(Integer.parseInt(tmp[k])==answer.get(j)){
                        tmp[k]="0";
                        break;
                    }
                }
            }
            for(int j=0;j<tmp.length;j++){
                if(!tmp[j].equals("0")){
                    answer.add(Integer.parseInt(tmp[j]));
                    break;
                }
            }
        }
        
        
        return answer;
    }
}