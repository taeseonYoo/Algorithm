import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        char[] chars = number.toCharArray();
        Arrays.sort(chars);

        int sum = 0;
        for (char ch : chars) {
            sum += ch - '0';
        }

        if (sum % 3 != 0 || chars[0] != '0') {
            System.out.println(-1);
            return;
        }

        String reversed = new StringBuilder(new String(chars)).reverse().toString();

        System.out.println(reversed);
    }

}