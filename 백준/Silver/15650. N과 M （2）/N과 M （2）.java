import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n,m;
    static List<Integer> l = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check(0);

        System.out.print(sb);
    }

    static void check(int start) {
        if (l.size() == m) {
            for (int a : l) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start+1; i<=n ; i++) {
            l.add(i);
            check(i);
            l.remove(l.get(l.size() - 1));
        }
    }



}



