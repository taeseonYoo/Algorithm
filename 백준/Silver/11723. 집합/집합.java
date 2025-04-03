import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        int s=0;
        StringTokenizer st;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();

            if(a.equals("all")) s = (1 << 21) - 1;
            else if (a.equals("empty")) {
                s = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                if(a.equals("add")) s |= (1 << num);
                else if(a.equals("remove")) s &= ~(1 << num);
                else if(a.equals("check")) sb.append((s & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(a.equals("toggle")) s ^= (1 << num);
            }

            
        }
        System.out.print(sb);

    }
}



