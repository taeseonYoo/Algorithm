import java.io.*;
import java.util.*;

/**
 * 1. 알고리즘
 * 2. 자료구조
 */

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][n+1];

        dp[0][0] = 1; //A
        dp[1][0] = 0; //B

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }

        System.out.println(dp[0][n] + " " + dp[1][n]);
    }

}
