import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> st = new Stack<>();

        int answer = 0;
        int bar = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '('){
                bar++;
                st.push(ch);
            }
            if (ch == ')'){
                bar--;
                if (st.peek()=='('){
                    answer+= bar;
                }else{
                    answer++;
                }
                st.push(ch);
            }
        }

        System.out.println(answer);
    }
}