import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for(int i=1;i<=N;i++){
                    if(i%num !=0) continue;
                    arr[i] = (arr[i] == 1) ? 0 : 1;
                }
            }else{
                int left=num,right=num;
                while(true){
                    if(left < 1 || right > N || (arr[left] != arr[right])){
                        left++;
                        right--;
                        break;
                    }
                    left--;
                    right++;
                }
                
                for (int i = left; i <= right; i++) {
                    arr[i] = (arr[i] == 1) ? 0 : 1;
                }
            }
        }

        int count=0;
        for (int i = 1; i <= N; i++) {

            if (count == 20) {
                System.out.println();
                count = 0;
            }
            System.out.print(arr[i] + " ");
            count++;

        }

    }
}
