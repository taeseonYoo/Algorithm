import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            //주가
            int[] price = new int[N];

            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int maxPrice = 0;
            //역방향 탐색으로 미래를 예측하는 효과를 낸다.
            for (int i = N - 1; i >= 0; i--) {
                if (price[i] > maxPrice) {
                    maxPrice = price[i];
                }else{
                    sum += maxPrice - price[i];
                }
            }
            answer.append(sum).append("\n");
        }
        System.out.println(answer);
    }
}