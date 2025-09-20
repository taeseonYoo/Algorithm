import java.io.*;
import java.util.*;



public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < N; i++) {
            s.add(Integer.valueOf(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (s.contains(a)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
