import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 6588 {
    static final int MAX_CASE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] findDecimal = decimalArray();


        // 0이 입력되기 전까지 값을 입력받는다.

        while (true){
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;
            boolean findSomething = false;
            if (n > MAX_CASE) {
                System.out.println("Goldbach's conjecture is wrong.");
                continue;
            }

            for (int j = 2; j <= n/2 ; j++) {
                if (findDecimal[j] && findDecimal[n-j]){
                    System.out.println(n + " = " + j + " + " + (n-j));
                    findSomething = true;
                    break;
                }
            }
            if (!findSomething){
                System.out.println("Goldbach's conjecture is wrong.");
            }


        }



    }


    // 소수인지 아닌지를 판단해주는 배열
    static boolean[] decimalArray(){
        boolean[] decimals = new boolean[MAX_CASE+1];

        // 0, 1 소수 아님
        decimals[0] = decimals[1] = false;

        for (int i = 2; i <= MAX_CASE; i++) {
            decimals[i] = true;
        }

        for (int i = 2; i < MAX_CASE; i++) {
            if (!decimals[i]) {
                continue;
            }
            if (decimals[i]){
                for (int j = i + i; j <= MAX_CASE; j += i) {
                    decimals[j] = false;
                }
            }
        }
        return decimals;
    }
}