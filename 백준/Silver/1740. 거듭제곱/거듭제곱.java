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

        long n = Long.parseLong(st.nextToken());

        BigInteger result = BigInteger.ZERO;

        for (int i = 39; i >= 0; i--) {
            if ((n & (1L << i)) != 0) {
                result = result.add(BigInteger.valueOf(3).pow(i));
            }
        }
        System.out.println(result);
    }
}
