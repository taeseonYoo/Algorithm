import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String line1 = br.readLine();
            String[] split1 = line1.split(" ");
            weight[i] = Integer.parseInt(split1[0]);
            value[i] = Integer.parseInt(split1[1]);
        }

        //가치의 최댓값을 저장하는 배열
        dp = new int[N+1][K+1];

        // 각 물건의 무게와 가치를 더한다.
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], value[i]+dp[i-1][j-weight[i]]);
                }
            }
        }
        System.out.println(dp[N][K]);

        return;
    }

}
