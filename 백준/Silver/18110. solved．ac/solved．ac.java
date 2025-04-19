import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        int round = (int) Math.round(n * 0.15);

        int sum =0;
        for (int i = round; i < n - round; i++) {
            sum += level[i];
        }
        int result = (int) Math.round((float)sum / (n - (round * 2)));

        System.out.println(result);


    }


}


