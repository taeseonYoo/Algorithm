import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //메모이 제이션을 위한 배열 선언
    static int dp[][][];

    public static void main(String[] args) throws IOException {

        int a,b,c;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[21][21][21];

        while(true){
            String line = br.readLine();
            String[] s = line.split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            //종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
        }

    }

    public static int w(int a,int b,int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        }
        //저장 된 값이 존재하면 리턴
        if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
