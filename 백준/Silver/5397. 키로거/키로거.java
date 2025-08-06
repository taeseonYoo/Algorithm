
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());

        Deque<Character> answer = new ArrayDeque<>();
        Deque<Character> tmp = new ArrayDeque<>();


        while (T > 0) {
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (isChar(ch)) { //문자는 정답에 저장한다.
                    answer.addLast(ch);
                } else if (ch == '-') {
                    if (!answer.isEmpty()) answer.pollLast();
                } else if (ch == '<') {
                    if (!answer.isEmpty()) {
                        tmp.addLast(answer.pollLast());
                    }
                } else if (ch == '>') {
                    if (!tmp.isEmpty()) {
                        answer.addLast(tmp.pollLast());
                    }
                }
            }

            //정답 출력
            StringBuilder sb = new StringBuilder();
            while (!answer.isEmpty()) {
                sb.append(answer.pollFirst());
            }
            while (!tmp.isEmpty()) {
                sb.append(tmp.pollLast());
            }
            System.out.println(sb);

            T--;
        };


    }

    static boolean isChar(char ch) {
        return ch != '-' && ch != '<' && ch != '>';
    }

}
