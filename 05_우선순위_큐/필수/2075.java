import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 큰 값 반환
                return Integer.compare(b, a);
            }
        });

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int[][] input = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 입력값 받기
                input[i][j] = s.nextInt();
                pq.add(input[i][j]);
            }
        }


        // 자신의 한 칸 위에 있는 수보다 크다는 조건 만족하는지 확인
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] < input[i-1][j]){
                    System.out.println("조건을 만족하지 못한다.");
                    return;
                }
            }
        }

        int result = 0;

        // nullPointerException을 피하기 위해서 체크하는 과정을 넣어준다.
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty()){
                result = pq.poll();
            } else {
                System.out.println("Empty queue");
            }
        }

        System.out.println(result);
    }
}