import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<FileName> fileNames = new ArrayList<>();
        
        for(String file : files){
            FileName fileName = new FileName(file);
            fileNames.add(fileName);
        }
        
        Collections.sort(fileNames, (a, b) -> {
            int headCompare = a.HEAD.toLowerCase().compareTo(b.HEAD.toLowerCase());
            if (headCompare != 0) return headCompare;

            int numA = Integer.parseInt(a.NUMBER);
            int numB = Integer.parseInt(b.NUMBER);
            return Integer.compare(numA,numB);
        });
        
        for(int i=0;i<files.length;i++){
            answer[i] = fileNames.get(i).getFileName();
        }
        
        
        return answer;
    }
}

class FileName{
    String HEAD;
    String NUMBER;
    String TAIL;
    
    public FileName(String file){
        int nextIdx = setHead(file);
        int tailIdx = setNumber(file, nextIdx);
        this.TAIL = file.substring(tailIdx);
    }
    
    public String getFileName(){
        return HEAD + NUMBER + TAIL;
    }
    
    private int setHead(String file){
        String result = "";
        int idx = 0;
        for(idx=0;idx<file.length();idx++){
            char ch = file.charAt(idx);
            if(Character.isDigit(ch)){
                break;
            }else{
                result += ch;
            }
        }
        this.HEAD = result;
        return idx;
    }
    private int setNumber(String file, int idx){
        
        String result = "";
        int i=0;
        for(i=idx;i<file.length();i++){
            char ch = file.charAt(i);
            if(!Character.isDigit(ch)){
                break;
            }else{
                result += ch;
            }
        }
        this.NUMBER = result;
        return i;
    }
}