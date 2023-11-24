import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int length = (int)Math.pow(2, N);
		int height = (int)Math.pow(2, N);
		int size = length * height;
		int index = 0;
		while (true) {
			length /= 2;
			height /= 2;
			size /= 4;
			if (length <= x && height > y) {
				index += size;
				x-= length;
			} else if (length > x && height <= y){
				index += size * 2;
				y-= height;
			}else if (length <= x){
				index += size * 3;
				x-= length;
				y-= height;
			}
			if(size == 0){
				break;
			}
		}
		System.out.println(index);

	}
}
