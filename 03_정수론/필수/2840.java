import java.util.Scanner;


public class 2840 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();

        // 바퀴의 칸 수 만큼 배열로 만들기
        char[] wheel = new char[N];
        // 중복 확인을 위해 알파벳 개수만큼 배열 생성
        int[] arr = new int[26];
        // 글자가 바뀐 횟수
        int[] S = new int[K];
        // 바퀴가 멈췄을 때 가리키던 글자
        char[] stopChar = new char[K];

        // 바퀴를 돌리는 횟수인 K번만큼 입력을 받는다.
        for (int i = 0; i < K; i++) {
            S[i] = s.nextInt();
            stopChar[i] = s.next().charAt(0);
        }

        // 바퀴 배열의 값의 ?로 초기화
        for (int i = 0; i < N; i++) {
            wheel[i] = '?';
        }
        // 알파벳 배열을 -1로 초기화
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        int index = -1;
        int present = 0;

        for (int i = 0; i < K; i++) {
            // 현재 가리키는 위치
            present = (index + S[i]) % N;
            // 인덱스 값 갱신
            index = present;
            // ?이 아니면 이미 숫자가 입력된 상황 + 숫자가 입력되었는데 내가 입력하려는 숫자랑 다르다면 오류이므로 ! 출력하고 바로 종료
            if (wheel[present] != '?' && stopChar[i] != wheel[present]){
                System.out.println("!");
                return;
            } else if(arr[stopChar[i] - 'A'] != -1 && arr[stopChar[i] - 'A'] != index){
                // 중복으로 다른 곳에서 이미 사용된 상황
                System.out.println("!");
                return;
            } else {
                // 올바를 상황
                // 올바른 위치에 알파벳을 넣어준다.
                wheel[present] = stopChar[i];
                // 위치 저장
                arr[stopChar[i] - 'A'] = index;
            }
        }

        // 마지막 입력값의 위치 찾기
        int print = arr[stopChar[K-1] - 'A'];

        // 바퀴 출력은 시계방향으로 출력되어야 하므로 --로 해야한다.
        for (int i = print; i >= 0 ; i--) {
            System.out.print(wheel[i]);
        }
        for (int i = N-1; i > print ; i--) {
            System.out.print(wheel[i]);
        }

    }
}