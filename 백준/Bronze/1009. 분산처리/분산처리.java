import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a;
        int b;
        for (int i = 0; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int c;
            if (b % 4 == 0) {
                c = 4;
            } else {
                c = b % 4;
            }
            int ans = (int) Math.pow(a, c) % 10;
            if (ans % 10 == 0){
                sb.append(10 + "\n");
            } else{
                sb.append(ans + "\n");
            }
            
        }
        System.out.print(sb);

    }
    }