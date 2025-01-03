import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String,Integer> mp = new HashMap();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int k = Integer.parseInt(line[0]);
        int l = Integer.parseInt(line[1]);


        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            mp.put(s, i);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());

        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : list) {
            if(k<=0) break;
            System.out.println(entry.getKey());
            k--;
        }
    }


}

