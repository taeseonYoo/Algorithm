import java.io.*;
import java.util.*;

/**
 * 1. 아이디어
 * 최대한 많은 회의를 진행해야한다.
 * 정렬을 통해 가장 빨리 끝나는 회의부터 진행한다.
 * 2. 시간복잡도
 * 회의의 수는 10만으로, N^2이면 시간초과가 발생할 것이다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        list.sort((a,b)->{
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }else{
                return a[0] - b[0];
            }
        });

        int endTime = list.get(0)[1];
        answer++;

        for (int i = 1; i < N; i++) {
            if (endTime <= list.get(i)[0]) {
                answer++;
                endTime = list.get(i)[1];
            }
        }

        System.out.println(answer);
    }
}