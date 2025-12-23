import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준 11052
 * 1. 시간 복잡도
 * O(n) * O(N^2)
 * 2. 공간 복잡도
 * 가격 정보를 담는 n+1개의 배열
 * dp를 담는 n+1개의 배열
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] prices = new int[n+1];

        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        dp[1] = prices[1];

        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                for (int k = j; k < i; k++) {
                    if (j + k == i) {
                        dp[i] = Math.max(dp[j] + dp[k], dp[i]);
                    }
                }
            }
        }

        System.out.println(dp[n]);


    }
}
