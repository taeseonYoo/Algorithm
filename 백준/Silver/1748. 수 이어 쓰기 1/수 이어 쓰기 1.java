import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result =0;
        int digit = 10;

        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (i % digit == 0) {
                cnt++;
                digit*=10;
            }
            result += cnt;
        }



        System.out.println(result);

    }
}
