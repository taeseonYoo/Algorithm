import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            map.put(line, map.getOrDefault(line, 0) + 1);
            count++;
        }

        List<String> arr = new ArrayList<>(map.keySet());

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size(); i++) {
            double ratio = map.get(arr.get(i)) / (double)count * 100;
            sb.append(arr.get(i)+" "+String.format("%.4f",ratio)).append("\n");
        }

        System.out.println(sb.toString());

    }

}
