import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        Set<Integer> s = new HashSet<>();
        int[] dp = new int[k+1];
        Arrays.fill(dp, 100001);

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            if(k>=a) s.add(a);
        }

        for(int i=1;i<=k;i++){
            int min = dp[i];
            for (int a : s) {
                if(dp[a]==100001) dp[a] = 1;
                if(i>=a) min = Math.min(min,dp[i-a]+1);
            }
            dp[i] = min;
        }

        if(dp[k]==100001) System.out.println(-1);
        else System.out.println(dp[k]);

    }


}

