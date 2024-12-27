import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<Integer> list = new ArrayList<>();

        String[] line = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(line[i]));
        }

        Collections.sort(list);

        int target = list.get((list.size()-1)/2);

        System.out.println(target);
    }


}

