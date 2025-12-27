import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = 3;
        int answer = 4;


        for (int i = 1; i <= n; i++) {
            answer = start * start;
            start = start + (start - 1);
        }

        System.out.println(answer);


    }
}
