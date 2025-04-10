import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int resultX=0,resultY=0;
        int start=0,end=n-1;
        while(start<end){
            int mid = arr[start] + arr[end];
            if(mid<0){
                int num = Math.abs(mid);
                if (result > num) {
                    resultX=start;
                    resultY=end;
                    result = num;
                }
                start++;
            } else if (mid > 0) {
                int num = Math.abs(mid);
                if (result > num) {
                    resultX=start;
                    resultY=end;
                    result = num;
                }
                end--;
            }else{
                resultX = start;
                resultY = end;
                break;
            }
        }
        System.out.println(arr[resultX] + " " + arr[resultY]);

    }
}
