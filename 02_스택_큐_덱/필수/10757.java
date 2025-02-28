import java.math.BigInteger;
import java.util.Scanner;

// BigInteger
// 큰 수에 대한 연산을 할 때 사용
// Int, Long으로도 계산이 안 될때

public class 10757 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        BigInteger A = s.nextBigInteger();
        BigInteger B = s.nextBigInteger();


        System.out.println(A.add(B));
    }
}