import java.io.*;
import java.util.*;


/**
 * 초밥의 종류를 번호로 표현
 * 같은 종류의 초밥이 있을 수 있다.
 * k개의 연속된 접시를 먹으면 정액가
 * 쿠폰을 발행하고 참가하면 초밥하나 무료제공
 * 최대한 다양한 초밥을 먹을 수 있도록 한다.
 *
 */

public class Main {

    static int N,d,k,c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //접시의 수
        d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); //쿠폰 번호 c

        List<Integer> belt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int sushi = Integer.parseInt(br.readLine());
            belt.add(sushi);
        }

        int answer = 0;

        Map<Integer,Integer> mp = new HashMap<>();

        mp.put(c, 1);

        for (int i = 0; i < k; i++) {
            int target = belt.get(i);
            mp.put(target, mp.getOrDefault(target, 0) + 1);
        }
        answer = Math.max(answer, mp.size());

        for (int i = 0; i < N; i++) {

            //앞의 초밥을 제거한다.
            Integer removeSushi = belt.get(i);
            if (mp.get(removeSushi) == 1) mp.remove(removeSushi);
            else mp.put(removeSushi, mp.get(removeSushi)-1);

            //뒤의 초밥을 추가한다.
            int end = i + k;
            if (end >= N) end %= N;
            Integer addSuShi = belt.get(end);
            mp.put(addSuShi, mp.getOrDefault(addSuShi, 0) + 1);


            answer = Math.max(answer, mp.size());
        }

        System.out.println(answer);
    }

}
