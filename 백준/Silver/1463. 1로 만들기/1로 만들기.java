import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static int a = 0;
    public static int toone(int n){

        if (n == 1 & ( a == 0 | a > count)) {
            a = count;
            count --;
            return a;
        }
        if (( a == 0 | a > count)) {
            

            if (n % 3 == 0) {
                count++;
                toone(n / 3);
            }
            if (n % 2 == 0) {
                count++;
                toone(n / 2);
            }
            count++;
            toone(n - 1);


        }
        count --;
        return a;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        int b = Main.toone(n);
        System.out.print(b);


    }

}