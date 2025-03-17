import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int idx=0;
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            arr[idx++]=Integer.parseInt(s);
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int[] result = {start,end};
        int min = Integer.MAX_VALUE;
        while(start<end){
            int target = arr[start] + arr[end];

            if(min > Math.abs(target)){
                min = Math.abs(target);
                result[0]=start;
                result[1]=end;
            }

            if(target < 0) {
                start++;
            } else{
                end--;
            }

        }

        System.out.println(arr[result[0]] + " " + arr[result[1]]);
    }


}

