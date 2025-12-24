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

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    length[i] = Math.max(length[i], length[j] + arr[i]);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, length[i]);
        }

        System.out.println(answer);
    }

}
