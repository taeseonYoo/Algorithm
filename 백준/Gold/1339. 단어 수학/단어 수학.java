import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                arr[line.charAt(j) - 'A'] += (int)Math.pow(10, line.length() - j - 1);
            }
        }

        Arrays.sort(arr);

        int result = 0;
        int a = 9;
        for (int i = arr.length-1; i>=0 ;i--) {
            if(arr[i]==0) continue;
            result += arr[i]*a;
            a--;
        }
        System.out.println(result);



    }


}

