import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 1;

        int earth = 1, sun = 1, moon = 1;

        while (earth != E || sun != S || moon != M) {
            earth++;
            sun++;
            moon++;

            if (earth == 16) {
                earth = 1;
            }
            if (sun == 29) {
                sun = 1;
            }
            if (moon == 20) {
                moon = 1;
            }

            answer++;
        }
        System.out.println(answer);
    }
}
