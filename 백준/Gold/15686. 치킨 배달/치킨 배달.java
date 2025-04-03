import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer[]> home = new ArrayList<>();
    static List<Integer[]> chicken = new ArrayList<>();
    static List<Integer[]> select = new ArrayList<>();
    static int n,m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    home.add(new Integer[]{i, j});
                }
                if (num == 2) {
                    chicken.add(new Integer[]{i, j});
                }
            }
        }

        check(0, 0);

        System.out.println(result);

    }
    static int result = Integer.MAX_VALUE;
    static void check(int start, int depth) {
        if (depth == m) { //치킨 거리 계산

            int total = 0;
            for (Integer[] a: home) {
                int min = Integer.MAX_VALUE;
                for (Integer[] b : select) {
                    int dist = Math.abs(b[0] - a[0]) + Math.abs(b[1] - a[1]);
                    min = Math.min(min, dist);
                }
                total += min;
            }
            result = Math.min(result, total);
        }

        for (int i = start; i < chicken.size(); i++) {
            select.add(chicken.get(i));
            check(i + 1, depth + 1);
            select.remove(select.size() - 1);
        }
    }


}



