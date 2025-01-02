import java.util.*;

class Solution {
    public boolean[] isPrime;
    public Set<Integer> uniqueValue = new HashSet<>();
    
    public int solution(String numbers) {
        
        int num = (int) Math.pow(10, numbers.length());
        initPrime(num);
        
        permutation("",numbers);
        
        return uniqueValue.size();
    }
    public void initPrime(int num){
        
        isPrime = new boolean[num+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(isPrime[i]){
                int j=2;
                while(i*j<=num){
                    isPrime[i*j]=false;
                    j++;
                }
            }
        }
    }
    
    public void permutation(String answer,String str){
        
        if(!answer.isEmpty()){
            int a = Integer.parseInt(answer);
            if(isPrime[a]){
                
                uniqueValue.add(a);
            }
        }
        
        for(int i=0;i<str.length();i++){
            permutation(answer+str.charAt(i), str.substring(0,i)+str.substring(i+1));
        }
    }
    
    
   
}