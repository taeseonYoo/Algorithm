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

        int N = Integer.parseInt(st.nextToken());

        int minSize = 1;
        while (minSize < N) {
            minSize *= 2;
        }

        int left = 31 - Integer.numberOfLeadingZeros(minSize);
        int right = Integer.numberOfTrailingZeros(N);

        System.out.println(minSize + " " + (left - right));


//        System.out.println(minSize + " " + count);
    }
}
