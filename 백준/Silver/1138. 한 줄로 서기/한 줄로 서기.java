import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        int idx = 1;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n+1];

        for (int i = 1; i <= n; i++) {

            int cnt = 0;
            if(arr[i]==0){
                for(int k=1;k<=n;k++){
                    if (answer[k] == 0) {
                        answer[k]=i;
                        break;
                    }
                }
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if(answer[j]==0){
                    cnt++;
                }
                if (cnt == arr[i]) {
                    for(int k=j+1;k<=n;k++){
                        if (answer[k] == 0) {
                            answer[k]=i;
                            break;
                        }
                    }
                    break;
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }





    }

}

