import java.io.*;
import java.util.*;

/**
 * 1. 아이디어
 * N과 M이 각각 백만이다.
 * N*M이 걸리는 방식으로 풀이할 수 없다.
 * 바이너리 서치를 사용하면, O(N*logM)으로 풀이할 수 있다.
 */

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N==0 && M == 0) break;

            answer = 0;

            int[] sk = new int[N];
            int[] sy = new int[M];

            //상근이의 CD
            for (int i = 0; i < N; i++) {
                sk[i] = Integer.parseInt(br.readLine());
            }
            //선영이의 CD
            for (int i = 0; i < M; i++) {
                sy[i] = Integer.parseInt(br.readLine());
            }

            //상근이의 CD를 기준으로, 선영이의 CD를 탐색한다.
            for (int i = 0; i < N; i++) {
                int target = sk[i];

                binarySearch(sy,target);
            }
            System.out.println(answer);
        }
    }

    static void binarySearch(int[] cluster, int target) {
        int start = 0;
        int end = cluster.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (cluster[mid] > target) {
                end = mid-1;
            }else if(cluster[mid] < target){
                start = mid+1;
            } else if (cluster[mid] == target) {
                answer++;
                return;
            }
        }
    }
}