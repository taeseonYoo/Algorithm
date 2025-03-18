import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int l = Integer.parseInt(split[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> a = new ArrayList<>();

        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);

        int result = 0;

        int range = 0;
        for (int i = 0; i < n; i++) {
            int pos = a.get(i);
            if (pos > range) {
                range = a.get(i)+l-1;
                result++;
            }
        }
        System.out.println(result);

    }

}

