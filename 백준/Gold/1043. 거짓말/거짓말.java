import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * O(log N)
 * 2. 공간 복잡도
 * link, size, room을 위한 배열 n+1
 * 3. 아이디어
 * 유니온 파인드
 */
class Main{
    static int[] link;
    static int[] size;
    static int[] room;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //사람의 수 n과 파티의 수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        size = new int[n + 1];
        room = new int[m];

        for (int i = 1; i <= n; i++) link[i] = i;
        for (int i = 1; i <= n; i++) size[i] = 1;

        st = new StringTokenizer(br.readLine());
        //진실을 아는 사람의 수
        int trueCount = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < trueCount; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            room[i] = people;

            for (int j = 1; j < peopleCount; j++) {
                int next = Integer.parseInt(st.nextToken());
                unite(people, next);
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            for (Integer truer : list) {
                if (same(room[i], truer)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }
        System.out.println(result);

    }
    public static int find(int x) {
        while(x != link[x]) x = link[x];
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