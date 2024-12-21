import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String say = bf.readLine();
            String[] split = say.split(" ");

            Map<String, Integer> mp = new HashMap<>();

            for (int j = 0; j < split.length; j++) {
                mp.put(split[j],mp.getOrDefault(split[j],0)+1);
            }

            while (true) {
                String line = bf.readLine();
                if (line.equals("what does the fox say?")) {

                    StringBuilder sb = new StringBuilder();
                    for (String s : split) {
                        if (!mp.containsKey(s)) {
                            continue;
                        }
                        sb.append(s);
                        sb.append(" ");
                    }
                    System.out.println(sb.toString());
                    break;
                }
                String[] sounds = line.split(" ");
                mp.remove(sounds[2]);
            }
        }




    }
}

