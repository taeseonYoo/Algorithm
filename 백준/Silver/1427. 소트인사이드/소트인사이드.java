import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = new int[10];

        char[] nums = br.readLine().toCharArray();

        for (int i = 0; i < nums.length; i++) {
            char num = nums[i];
            counts[num-'0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (counts[i] > 0) {
                sb.append(i);
                counts[i]--;
            }
        }

        System.out.println(sb);
    }


}
