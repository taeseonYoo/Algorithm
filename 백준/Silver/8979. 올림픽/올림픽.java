import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer[]> medal = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medal.add(new Integer[]{num, gold, silver, bronze});
        }

        Collections.sort(medal, new Comparator<>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1]<o2[1]) return 1;
                else if (o1[1].equals(o2[1])) {
                    if(o1[2]<o2[2]) return 1;
                    else if (o1[2].equals(o2[2])) {
                        if(o1[3]<o2[3]) return 1;
                        else return -1;
                    }else return -1;
                }else return -1;
            }
        });



        int rank = 1;

        for (int i = 0; i < medal.size(); i++) {

            if (i > 0) {
                Integer[] before = medal.get(i-1);
                Integer[] next = medal.get(i);

                if(!(before[1].equals(next[1])&&
                        before[2].equals(next[2])&&
                        before[3].equals(next[3]))){
                    rank = i+1;
                }
            }
            if (medal.get(i)[0] == k) {
                System.out.println(rank);
                break;
            }
        }


    }


}


