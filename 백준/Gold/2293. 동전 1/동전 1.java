import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        for(int i=0;i<n;i++){
            int target = coin[i];
            if(target>k) break;
            dp[target]++;
            for(int j=target+1;j<=k;j++){
                if(j-target>0) dp[j] = dp[j]+dp[j-target];
            }
        }

        System.out.println(dp[k]);

    }


}

