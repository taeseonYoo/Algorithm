import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 10844
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = 1_000_000_000;

        int[][] dp = new int[n+1][10];

        //값 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % k;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % k;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1] ) % k;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i] ;
            sum %= k;
        }
        System.out.println(sum);
    }
}
