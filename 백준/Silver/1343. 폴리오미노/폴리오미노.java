import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line  = bf.readLine();

        line = line.replace("XXXX","AAAA");
        line = line.replace("XX", "BB");

        if (line.contains("X")) System.out.println(-1);
        else System.out.println(line);


    }


}

