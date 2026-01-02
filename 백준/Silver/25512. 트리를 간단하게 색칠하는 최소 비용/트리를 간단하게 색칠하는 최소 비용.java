import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 백준 25512
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{
    static ArrayList<Integer>[] graph;
    static int[][] prices;
    static int[] color;
    static int n;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[p].add(c);
        }

        prices = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            prices[i][0] = w;
            prices[i][1] = b;
        }

        long answer = n * 100_000L;
        //0은 화이트, 1은 블랙 ,2는 방문하지 않은 노드
        for (int c = 0; c < 2; c++) {
            //값 초기화
            result = 0;
            color = new int[n];
            Arrays.fill(color, 2);
            //색칠 시작
            dfs(0, c);
            answer = Math.min(answer, result);
        }
        System.out.println(answer);
    }

    static void dfs(int start,int c) {
        if (color[start]!=2) return;
        color[start] = c;

        int priceIdx = c == 1 ? 0 : 1;
        result += prices[start][priceIdx];

        for (int next : graph[start]) {
            int nextColor = (c == 1) ? 0 : 1;
            dfs(next, nextColor);
        }
    }
}
