import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = n;

        int[] light = new int[m];
        for (int i = 0; i < m; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }
        int result = n;

        while (start <= end) {
            int mid = (start + end)/2;
            boolean pos = false;


            for (int i = 1; i < m; i++) {
                int dist = light[i]-light[i-1];
                if (dist > mid*2) {
                    pos = true;
                    break;
                }
            }
            if (light[0] > mid || (n - light[m - 1]) > mid) {
                pos = true;
            }

            if(pos){
                start = mid+1;
            }else{
                result = Math.min(mid, result);
                end = mid-1;
            }

        }

        System.out.println(result);



    }
}
