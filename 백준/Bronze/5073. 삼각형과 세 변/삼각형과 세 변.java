import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = bf.readLine();
            if (line.equals("0 0 0")) {
                break;
            }

            String[] str = line.split(" ");

            int[] arr = new int[3];

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(str[i]);
                sum += arr[i];
            }

            int max = Math.max(arr[0], Math.max(arr[1], arr[2]));


            if (max >= sum - max) {
                System.out.println("Invalid");
                continue;
            }

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Equilateral");
            } else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }

        }
        
    }




}

