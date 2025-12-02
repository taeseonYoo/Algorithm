import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * O(logN)이다.
 * find, unite
 *
 * 2. 공간 복잡도
 *  link는 경로상의 다음 원소를 저장
 *  size는 집합의 크기를 저장하는 배열
 *  두 배열의 크기는 n+1
 * 3. 아이디어
 * Union Find
 */
class Main{
    static int[] link;
    static int[] size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) link[i] = i;
        for (int i = 1; i <= n; i++) size[i] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int decide = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //a가 포함된 집합과 b가 포함된 집합을 합친다.
            if (decide == 0) {
                unite(a, b);
            } else if (decide == 1) { //두 원소가 같은 집합에 포함되어 있는지를 확인한다.
                if (same(a, b)) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }

    }

    //대푯값을 반환하는 함수
    public static int find(int x) {
        while (x!=link[x]) x = link[x];
        return x;
    }

    public static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    public static void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        size[a] += size[b];
        link[b] = a;
    }
}