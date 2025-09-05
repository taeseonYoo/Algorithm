import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        int[] valid = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            valid[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[4];
        //초기 셋팅
        for (int i = 0; i < P; i++) {
            char c = DNA.charAt(i);
            nums[count(c)]++;
        }

        int result=0;

        if (isValid(nums,valid)) result++;


        int start = 0;
        int end = start + P - 1;

        while(end<S-1){
            nums[count(DNA.charAt(start))]--;

            start++;
            end++;

            nums[count(DNA.charAt(end))]++;

            if (isValid(nums,valid)) result++;
        }
        System.out.println(result);


    }

    static int count(char ch) {
        if (ch == 'A') return 0;
        else if(ch=='C') return 1;
        else if (ch =='G') return 2;
        else return 3;
    }

    static boolean isValid(int[] current,int[] required) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
