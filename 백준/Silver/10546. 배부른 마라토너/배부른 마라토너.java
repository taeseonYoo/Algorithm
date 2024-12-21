import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());


        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = bf.readLine();

            mp.put(name, mp.getOrDefault(name,0)+1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = bf.readLine();
            int count = mp.get(name);
            if (count - 1 == 0) {
                mp.remove(name);
            }else{
                mp.put(name,count-1);
            }
        }

        for (String s : mp.keySet()) {
            System.out.println(s);
        }



    }
}

