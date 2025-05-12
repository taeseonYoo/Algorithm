import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine())!=null && !line.equals("end")){

            if(!checkVowel(line)){
                System.out.println("<" + line + "> " + "is not acceptable.");
                continue;
            }
            if(checkThree(line)){
                System.out.println("<" + line + "> " + "is not acceptable.");
                continue;
            }
            if (checkTwo(line)) {
                System.out.println("<" + line + "> " + "is not acceptable.");
                continue;
            }

            System.out.println("<" + line + "> " + "is acceptable.");

        }


    }

    static String[] vowels = {"a", "e", "i", "o", "u"};
    public static boolean checkVowel(String line) {
        for (int i = 0; i < vowels.length; i++) {
            if (line.contains(vowels[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkThree(String line) {
        int v=0;
        int c =0;

        for (int i = 0; i < line.length(); i++) {
            boolean flag = false;
            
            for (int j = 0; j < 5; j++) {
                if (line.charAt(i) == vowels[j].charAt(0)) {
                    v++;
                    c=0;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                v=0;
                c++;

            }
            if(v == 3 || c == 3){
                return true;
            }
        }
        return false;
    }
    public static boolean checkTwo(String line){
        for (int i = 1; i < line.length(); i++) {
            if(line.charAt(i)==line.charAt(i-1)){
                if (line.charAt(i) == 'e' || line.charAt(i) == 'o') {
                    continue;
                }
                return true;
            }
        }
        return false;
    }


}


