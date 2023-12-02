
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            map.put(i, 0);
        }

        while (number > 0) {
            int n = number % 10;
            map.put(n, map.get(n) + 1);
            number /= 10;
        }
        int sixAndNine = map.get(6) + map.get(9);
        int max = sixAndNine % 2 + sixAndNine / 2;
        map.remove(6);
        map.remove(9);

        for(Integer value : map.values()){
            if(max < value){
                max = value;
            }
        }

        System.out.println(max);



    }
}
