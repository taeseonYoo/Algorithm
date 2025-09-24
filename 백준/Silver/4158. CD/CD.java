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
    static int[] sk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N==0 && M == 0) break;

            answer = 0;

            //상근이의 CD
            sk = new int[N];

            //상근이의 CD 입력 받기
            for (int i = 0; i < N; i++) {
                sk[i] = Integer.parseInt(br.readLine());
            }
            //선영이의 CD
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(br.readLine());
                binarySearch(target);
            }
            
            System.out.println(answer);
        }
    }

    static void binarySearch(int target) {
        int start = 0;
        int end = sk.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (sk[mid] > target) {
                end = mid-1;
            }else if(sk[mid] < target){
                start = mid+1;
            } else if (sk[mid] == target) {
                answer++;
                return;
            }
        }
    }
}