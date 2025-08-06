
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());

        Stack<Character> answer = new Stack<>();
        Stack<Character> tmp = new Stack<>();


        while (T > 0) {
            String input = br.readLine();

            
            int cursor = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (isChar(ch)) { //문자는 정답에 저장한다.
                    answer.push(ch);
                } else if (ch == '-') {
                    if (!answer.empty()) answer.pop();
                } else if (ch == '<') {
                    if (!answer.empty()) {
                        tmp.push(answer.pop());
                    }
                } else if (ch == '>') {
                    if (!tmp.empty()) {
                        answer.push(tmp.pop());
                    }
                }
            }

            //정답 출력
            StringBuilder sb = new StringBuilder();
            while (!answer.empty()) {
                tmp.push(answer.pop());
            }
            while (!tmp.empty()) {
                sb.append(tmp.pop());
            }
            System.out.println(sb);

            T--;
        };


    }

    static boolean isChar(char ch) {
        return ch != '-' && ch != '<' && ch != '>';
    }

}
