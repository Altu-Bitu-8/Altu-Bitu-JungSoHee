import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] youngerArrays = new int[N];
        int[] absArrays = new int[N];


        st = new StringTokenizer(br.readLine()); // 동생들의 위치값을 새로운 입력으로 받기

        for (int i = 0; i < N; i++) {

            // 동생들의 위치값 입력 받기
            youngerArrays[i] = Integer.parseInt(st.nextToken());

            // 절댓값의 차 계산하기
            absArrays[i] = Math.abs(youngerArrays[i] - S);



        }

        if (N == 1){
            System.out.println(absArrays[0]);
        } else {
            for (int i = 1; i < N; i++) {
                absArrays[i] = gcd(absArrays[i-1],absArrays[i]);
            }
            System.out.println(absArrays[N-1]);
        }
    }


    private static int gcd(int a, int b){
        int temp = 0;
        if (a == b) return a;
        while (b != 0){
            a = a % b;

            temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}