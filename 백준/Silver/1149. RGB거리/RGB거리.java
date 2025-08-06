import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] color = new int[n][3];

        //누적된 최소금액을 저장하는 배열
        dp = new int[n][3];


        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            color[i][0] = Integer.parseInt(split[0]);
            color[i][1] = Integer.parseInt(split[1]);
            color[i][2] = Integer.parseInt(split[2]);
        }

        dp[0][0] = color[0][0];
        dp[0][1] = color[0][1];
        dp[0][2] = color[0][2];

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));

    }

}
