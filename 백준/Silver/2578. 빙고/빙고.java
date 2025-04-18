import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < 5; j++) {
                list.add(Integer.parseInt(split[j]));
            }
        }

        for (int i = 0; i < 25; i++) {
            int target = list.get(i);
            for (int j = 0; j <5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (bingo[j][k] == target) {
                        bingo[j][k]=0;
                        break;
                    }
                }
            }
            int check = check(bingo);
            if (check >= 3) {
                System.out.println(i + 1);
                return;
            }
        }



    }

    static int check(int[][] bingo) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }
        isBingo = true;
        for (int i = 4; i >=0; i--) {
            if (bingo[i][4-i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            count++;
        }

        return count;

    }

}

