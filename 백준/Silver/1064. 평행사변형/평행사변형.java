import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pt = new int[6];

        for (int i = 0; i < 6; i++) {
            pt[i] = Integer.parseInt(st.nextToken());
        }

        double a1 = 0, a2 = 0;
        if (pt[2] - pt[0] != 0) {
            a1 = (double)(pt[3] - pt[1]) / (pt[2] - pt[0]);
        }
        if (pt[4] - pt[2] != 0) {
            a2 = (double)(pt[5] - pt[3]) / (pt[4] - pt[2]);
        }

        //세 점이 한 직선 위에 있다면, -1을 출력한다.
        if (a1 == a2) {
            System.out.println(-1.0);
            return;
        }

        double l1 = Math.sqrt(Math.pow(pt[2] - pt[0], 2) + Math.pow(pt[3] - pt[1], 2));
        double l2 = Math.sqrt(Math.pow(pt[4] - pt[2], 2) + Math.pow(pt[5] - pt[3], 2));
        double l3 = Math.sqrt(Math.pow(pt[4] - pt[0], 2) + Math.pow(pt[5] - pt[1], 2));

        double max = Math.max(l1, Math.max(l2, l3));
        double min = Math.min(l1, Math.min(l2, l3));
        double mid = l1 + l2 + l3 - max - min;

        double answer = 2 * (max + mid) - 2 * (min + mid);

        System.out.println(answer);
    }
}
