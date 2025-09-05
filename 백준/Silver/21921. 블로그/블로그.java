import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] views = new int[n]; //방문자수 기록을 위한 배열

        for (int i = 0; i < n; i++) {
            views[i] = Integer.parseInt(st.nextToken());
        }


        

        long sum = 0;
        for (int i = 0; i < x; i++) {
            sum += views[i];
        }
        
        long max = sum; //최대 값을 저장한다.
        int count = 1; //최대 값인 경우의 수를 저장한다.


        for (int i = x; i < n; i++) {
            sum += views[i];
            sum -= views[i-x];


            if (max == sum) count++;
            else if (max < sum) {
                max = sum;
                count = 1;
            }
        }


        System.out.println(max == 0 ? "SAD" : max + "\n" + count);

    }


}
