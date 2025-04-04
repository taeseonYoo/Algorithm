import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int min = 257;
        int max = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }
        int[][] tmp;
        int resultTime = Integer.MAX_VALUE,resultHeight = Integer.MIN_VALUE;
        int tb;



        for(int k=min;k<=max;k++){
            tmp = arr;
            int time = 0;
            tb = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(tmp[i][j]<k){ //심는다
                        int value = k - tmp[i][j];
                        time+= value;
                        tb -= value;
                    }else if(tmp[i][j]>k){ //제거한다
                        int value = tmp[i][j] - k;
                        time+=2*value;
                        tb += value;
                    }
                }
            }

            if (tb >= 0) {

                if (time < resultTime) {
                    resultTime = time;
                    resultHeight = k;
                }else if(time == resultTime){
                    if (resultHeight < k) {
                        resultHeight = k;
                    }
                }
            }
        }
        System.out.println(resultTime +" "+resultHeight);




    }
}
