import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 백준 14002
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] length = new int[n];
        int[] before = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        before[i] = j;
                    }
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (max <= length[i]) {
                maxIdx = i;
                max = length[i];
            }
        }

        int count = max;
        while(count-- > 0){
            answer.add(arr[maxIdx]);
            maxIdx = before[maxIdx];
        }

        System.out.println(max);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(answer.size() - i - 1)+" ");
        }
    }
}
