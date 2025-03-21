import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // 큐에 값을 넣어준다.
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐에 카드가 1개 남을 때까지 poll, add를 반복
        while (queue.size() != 1){
            queue.poll();
            //poll한 값을 바로 add함
            queue.add(queue.poll());

        }

        // 마지막 남은 카드 확인
        System.out.println(queue.peek());

    }
}
