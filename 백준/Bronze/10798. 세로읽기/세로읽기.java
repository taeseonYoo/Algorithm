import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준 9656
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[5];

        StringBuilder sb = new StringBuilder();

        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            maxLen = Math.max(maxLen, words[i].length());
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}
